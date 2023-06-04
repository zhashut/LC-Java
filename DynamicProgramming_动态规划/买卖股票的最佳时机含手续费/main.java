package DynamicProgramming_动态规划.买卖股票的最佳时机含手续费;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/6/5
 * Time: 6:54
 * Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class main {
    // 卖出时支付手续费
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[n - 1][1];
    }

    // 买入时支付手续费
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        // 0 : 持股（买入）
        // 1 : 不持股（售出）
        // dp 定义第i天持股/不持股 所得最多现金
        int[][] dp = new int[len][2];
        // 考虑买入的时候就支付手续费
        dp[0][0] = -prices[0] - fee;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    // 一维数组优化
    public int maxProfit3(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1] - fee);
        }
        return dp[1];
    }
}
