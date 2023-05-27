package DynamicProgramming_动态规划.目标和;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/28
 * Time: 5:50
 * Description: https://leetcode.cn/problems/target-sum/
 */

/**
 * 原问题等同于： 找到nums一个正子集P和一个负子集N，使得总和等于target。即sum(P) - sum(N) == target，
 * 即sum(P) + sum(N) + sum(P) - sum(N) == target + sum(P) + sum(N)
 * 即2 * sum(P) == target + sum(nums)， 其中target + sum(nums)必须>=0且为偶数，否则等式不可能成立。
 * 则问题转换为：存在多少个子集P，使sum(P) == (target + sum(nums))/2。
 * <p>
 * dp[i][j]表示前i个元素有多少个目标和为j的子集。dp[0][0] = 1
 * 1. dp[i][j] = dp[i-1][j]
 * 2. 如果nums[0...i-2]存在目标和为j-nums[i-1]的子集，则dp[i][j] += dp[i-1][j-nums[i-1]]
 */
public class main {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
