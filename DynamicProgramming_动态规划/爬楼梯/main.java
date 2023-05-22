package DynamicProgramming_动态规划.爬楼梯;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/23
 * Time: 6:32
 * Description: https://leetcode.cn/problems/climbing-stairs/
 */
public class main {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
