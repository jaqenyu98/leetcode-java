package dp.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        int[] prefixSums = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
            map.putIfAbsent(prefixSums[i + 1], i + 1);
            int target = prefixSums[i + 1] - k;
            if (map.containsKey(target)) {
                maxLen = Math.max(maxLen, i + 1 - map.get(target));
            }
        }
        return maxLen;
    }
    // 空间小优化：滚动变量
    public int maxSubArrayLen2(int[] nums, int k) {
        int maxLen = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            map.putIfAbsent(prefixSum, i + 1);
            int target = prefixSum - k;
            if (map.containsKey(target)) {
                maxLen = Math.max(maxLen, i + 1 - map.get(target));
            }
        }
        return maxLen;
    }
}
