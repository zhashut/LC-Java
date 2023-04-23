package TwoPointers_双指针.有序数组的平方;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/23
 * Time: 20:02
 * Description: https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class main {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                res[i] = nums[left] * nums[left++];
            } else {
                res[i] = nums[right] * nums[right--];
            }
        }

        return res;
    }
}
