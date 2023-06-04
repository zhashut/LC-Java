package DynamicProgramming_动态规划.最佳买卖股票时机含冷冻期;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/6/5
 * Time: 6:02
 * Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class main {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][4];

        dp[0][0] = -prices[0]; // 持有股票状态

        for (int i = 1; i < n; i++) {
            // 持有股票状态
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            // 保持卖出股票状态
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // 卖出股票状态
            dp[i][2] = dp[i - 1][0] + prices[i];
            // 冷冻期
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(dp[n - 1][1], Math.max(dp[n - 1][2], dp[n - 1][3]));
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    // 一维数组优化
    public int maxProfit3(int[] prices) {
        int[] dp = new int[4];

        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            // 使用临时变量来保存dp[0], dp[2]
            // 因为马上dp[0]和dp[2]的数据都会变
            int temp = dp[0];
            int temp1 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp + prices[i - 1];
            dp[3] = temp1;
        }
        return Math.max(dp[3], Math.max(dp[1], dp[2]));
    }

    public int maxProfit4(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[1][0] = -prices[0];

        for (int i = 2; i <= prices.length; i++) {
            /*
            dp[i][0] 第i天持有股票收益;
            dp[i][1] 第i天不持有股票收益;
            情况一：第i天是冷静期，不能以dp[i-1][1]购买股票,所以以dp[i - 2][1]买股票，没问题
            情况二：第i天不是冷静期，理论上应该以dp[i-1][1]购买股票，但是第i天不是冷静期说明，第i-1天没有卖出股票，
                则dp[i-1][1]=dp[i-2][1],所以可以用dp[i-2][1]买股票，没问题
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
        }

        return dp[prices.length][1];
    }
}
