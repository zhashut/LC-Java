package 数组.长度最小的子数组;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/12
 * Time: 8:10
 * Description: https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class main {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Integer.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
