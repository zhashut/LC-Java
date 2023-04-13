package 数组.移除元素;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/11
 * Time: 20:21
 * Description: https://leetcode.cn/problems/remove-element/
 */
public class main {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slowIndex] = nums[i];
                slowIndex++;
            }
        }

        return slowIndex;
    }

    public int removeElement2(int[] nums, int val) {
        // 相向双指针法
        int left = 0;
        int right = nums.length - 1;
        // 将right移到从右数第一个值不为val的位置
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        while (left <= right) {
            // left位置的元素需要移除
            if (nums[left] == val) {
                // 将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while (right >= 0 && nums[right] == val) {
                right--;
            }
        }

        return left;
    }

}
