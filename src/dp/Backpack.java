package dp;

public class Backpack {
    public void backpack(int[] weight, int[] value, int bagWeight) {
        int n = weight.length;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[n][bagWeight + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
        /*------------------------------------------空间优化--------------------------------------------------------*/
        int[] dp2 = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for(int i = 0; i < n; i++) { // 遍历物品
            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                dp2[j] = Math.max(dp2[j], dp2[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp2[j] + " ");
        }
    }
}
