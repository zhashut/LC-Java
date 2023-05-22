package DynamicProgramming_动态规划.斐波那契数;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/23
 * Time: 6:20
 * Description: https://leetcode.cn/problems/fibonacci-number/
 */
public class main {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return dp[1];
    }
}
