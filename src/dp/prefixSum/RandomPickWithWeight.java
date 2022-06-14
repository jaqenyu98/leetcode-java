package dp.prefixSum;

import java.util.Random;

public class RandomPickWithWeight {
    int[] prefixSums;
    public RandomPickWithWeight(int[] w) {
        int len = w.length;
        prefixSums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSums[i + 1] = prefixSums[i] + w[i];
        }
    }
    public int pickIndex() {
        int len = prefixSums.length;
        // 要有这个+1，保证前开后闭
        int randomVal = new Random().nextInt(prefixSums[len - 1]) + 1;
        int left = 1;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 前开后闭，相等时属于左边的区间
            if (prefixSums[mid] >= randomVal) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right - 1;
    }
}
