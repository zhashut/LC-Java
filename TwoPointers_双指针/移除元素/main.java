package TwoPointers_双指针.移除元素;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/23
 * Time: 19:16
 * Description: https://leetcode.cn/problems/remove-element/
 */
public class main {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        // 找到最后一个不等于val的位置
        while (right >= 0 && nums[right] == val) {
            right--;
        }

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            }
            left++;
            while (right >= 0 && nums[right] == val) {
                right--;
            }
        }

        return left;
    }
}
