package Greedy_贪心.最大子数组和;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/16
 * Time: 18:34
 * Description: https://leetcode.cn/problems/maximum-subarray/
 */
public class main {
    // 贪心
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }

        return result;
    }

    // 动态规划
    public int maxSubArray2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ans = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
