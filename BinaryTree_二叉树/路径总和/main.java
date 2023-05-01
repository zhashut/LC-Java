package BinaryTree_二叉树.路径总和;

import BinaryTree_二叉树.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/30
 * Time: 19:26
 * Description: https://leetcode.cn/problems/path-sum/
 */
public class main {
    /**
     * 递归法
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
