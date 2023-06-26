package DynamicProgramming_动态规划.最大子数组和;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/6/26
 * Time: 20:31
 * Description: https://leetcode.cn/problems/maximum-subarray/
 */
public class main {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

    // 因为dp[i]的递推公式只与前一个值有关，所以可以用一个变量代替dp数组，空间复杂度为O(1)
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }
}
