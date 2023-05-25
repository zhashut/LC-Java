package DynamicProgramming_动态规划.不同的二叉搜索树;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/26
 * Time: 5:43
 * Description: https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class main {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
