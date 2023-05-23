package DynamicProgramming_动态规划.使用最小花费爬楼梯;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/24
 * Time: 5:34
 * Description: No Description
 */
public class main {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < cost.length; i++) {
            dp[i] += Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[cost.length];
    }
}
