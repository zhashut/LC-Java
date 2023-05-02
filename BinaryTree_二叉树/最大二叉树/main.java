package BinaryTree_二叉树.最大二叉树;

import BinaryTree_二叉树.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/2
 * Time: 21:44
 * Description: https://leetcode.cn/problems/maximum-binary-tree/
 */
public class main {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length);
    }

    private TreeNode traversal(int[] nums, int leftIndex, int rightIndex) {
        // 如果没有元素了，就返回null
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }

        int maxIndex = leftIndex;
        int maxValue = nums[maxIndex];
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = traversal(nums, leftIndex, maxIndex);
        root.right = traversal(nums, maxIndex + 1, rightIndex);

        return root;
    }
}
