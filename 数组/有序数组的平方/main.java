package 数组.有序数组的平方;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/12
 * Time: 7:45
 * Description: https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class main {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;

        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[i] * nums[i] >= nums[j] * nums[j]) {
                res[k] = nums[i] * nums[i];
                i++;
            } else {
                res[k] = nums[j] * nums[j];
                j--;
            }
        }

        return res;
    }
}
