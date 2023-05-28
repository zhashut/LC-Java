package DynamicProgramming_动态规划.组合总和Ⅳ;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/29
 * Time: 6:39
 * Description: https://leetcode.cn/problems/combination-sum-iv/
 */
public class main {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
