package DynamicProgramming_动态规划.买卖股票的最佳时机IV;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/6/4
 * Time: 7:35
 * Description: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class main {

    // 一维 dp数组
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        // 其实就是123题的扩展，123题只用记录2次交易的状态
        // 这里记录k次交易的状态就行了
        // 每次交易都有买入，卖出两个状态，所以要乘 2
        int[] dp = new int[2 * k];
        // 按123题解题格式那样，做一个初始化
        for (int i = 0; i < dp.length / 2; i++) {
            dp[i * 2] = -prices[0];
        }
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
            // 还是与123题一样，与123题对照来看
            // 就很容易啦
            for (int j = 2; j < dp.length; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i - 1]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i - 1]);
            }
        }
        // 返回最后一次交易卖出状态的结果就行了
        return dp[dp.length - 1];
    }

    // 二维 dp数组
    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];

        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }

        return dp[len - 1][2 * k];
    }

    // 三维 dp数组
    public int maxProfit3(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // [天数][交易次数][是否持有股票]
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];

        // dp数组初始化
        // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                // dp方程, 0表示不持有/卖出, 1表示持有/买入
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }
}
