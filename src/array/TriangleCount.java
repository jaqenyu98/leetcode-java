package array;

import java.util.Arrays;

public class TriangleCount {
    public int triangleCount(int[] s) {
        int result = 0;
        Arrays.sort(s);
        for (int i = s.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (s[left] + s[right] > s[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
