package dp.prefixSum;

public class MaximumSubarray {
    /*----------------------------------------动规------------------------------------------*/
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int result = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    // 空间优化
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int result = nums[0];
        int dp = nums[0];
        for (int i = 1; i < len; i++) {
            dp = Math.max(nums[i], dp + nums[i]);
            result = Math.max(result, dp);
        }
        return result;
    }
    /*----------------------------------------分治法-----------------------------------------*/
    public int maxSubArray3(int[] nums) {
        return maxSubArray3(nums, 0, nums.length - 1);
    }
    private int maxSubArray3(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = left + (right - left) / 2;
        int leftMax = maxSubArray3(nums, left, mid);
        int rightMax = maxSubArray3(nums, mid + 1, right);
        int crossingMax = maxSubarrayCrossing(nums, left, mid, right);
        return Math.max(leftMax, Math.max(rightMax, crossingMax));
    }
    private int maxSubarrayCrossing(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftMax = nums[mid];
        int rightMax = nums[mid + 1];
        for (int i = mid; i >= left ; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }
        return leftMax + rightMax;
    }
}
