package dfs;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    /*------------------------------------------------------回溯--------------------------------------------------------*/
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0);
        return result;
    }
    private void dfs(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            if (target == 0)
                result++;
            return;
        }
        dfs(nums, target + nums[idx], idx + 1);
        dfs(nums, target - nums[idx], idx + 1);
    }
    /*------------------------------------------------------记忆化回溯--------------------------------------------------------*/
    Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays2(int[] nums, int target) {
        return dfs2(nums, target, 0);
    }
    // 返回数量
    private int dfs2(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            if (target == 0)
                return 1;
            return 0;
        }
        String key = target + "," + idx;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int negative = dfs2(nums, target + nums[idx], idx + 1);
        int positive = dfs2(nums, target - nums[idx], idx + 1);
        memo.put(key, negative + positive);
        return negative + positive;
    }
    /*------------------------------------------------------动规--------------------------------------------------------*/
    public int findTargetSumWays3(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum < Math.abs(target))
            return 0;
        int[][] dp = new int[nums.length + 1][2 * totalSum + 1];
        dp[0][totalSum] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2 * totalSum; j++) {
                if (j - nums[i - 1] >= 0)
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                if (j + nums[i - 1] <= 2 * totalSum)
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
            }
        }
        return dp[nums.length][target + totalSum];
    }
    /*------------------------------------------------------动规优化--------------------------------------------------------*/
    public int findTargetSumWays4(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum < Math.abs(target) || (totalSum - target) % 2 != 0)
            return 0;
        int negative = (totalSum - target) / 2;
        int[][] dp = new int[nums.length + 1][negative + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= negative; j++) {
                if (j - nums[i - 1] >= 0)
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[nums.length][negative];
    }
    /*------------------------------------------------------动规再优化--------------------------------------------------------*/
    public int findTargetSumWays5(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum < Math.abs(target) || (totalSum - target) % 2 != 0)
            return 0;
        int negative = (totalSum - target) / 2;
        int[] dp = new int[negative + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = negative; j >= nums[i - 1]; j--) {
                dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[negative];
    }
}
