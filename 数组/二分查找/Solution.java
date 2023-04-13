package 数组.二分查找;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/11
 * Time: 19:55
 * Description: https://leetcode.cn/problems/binary-search/
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        search(nums, 9);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
