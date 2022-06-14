package multiPointers.slidingWindow;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int product = 1;
        int len = nums.length;
        while (right < len) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}
