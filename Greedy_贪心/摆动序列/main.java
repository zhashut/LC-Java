package Greedy_贪心.摆动序列;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/15
 * Time: 19:34
 * Description: https://leetcode.cn/problems/wiggle-subsequence/
 */
public class main {
    // 解法一：贪心
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curdiff = 0, prediff = 0, result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curdiff = nums[i + 1] - nums[i];
            if ((prediff >= 0 && curdiff < 0) || (prediff <= 0 && curdiff > 0)) {
                result++;
                prediff = curdiff;
            }
        }

        return result;
    }

    // 解法二：动态规划
    public int wiggleMaxLength2(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i 作为波谷的最大长度
        int dp[][] = new int[nums.length][2];

        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++){
            //i 自己可以成为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;

            for (int j = 0; j < i; j++){
                if (nums[j] > nums[i]){
                    // i 是波谷
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if (nums[j] < nums[i]){
                    // i 是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
