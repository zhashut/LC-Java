package DynamicProgramming_动态规划.打家劫舍;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/6/1
 * Time: 5:53
 * Description: https://leetcode.cn/problems/house-robber/
 */
public class main {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    // 解题二：空间优化 dp数组只存与计算相关的两次数据
    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 初始化dp数组
        // 优化空间 dp数组只用2格空间 只记录与当前计算相关的前两个结果
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = 0;
        // 遍历
        for (int i = 2; i < nums.length; i++) {
            res = Math.max((dp[0] + nums[i]), dp[1]);
            dp[0] = dp[1];
            dp[1] = res;
        }
        // 输出结果
        return dp[1];
    }
}
