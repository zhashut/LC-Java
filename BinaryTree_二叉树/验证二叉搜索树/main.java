package BinaryTree_二叉树.验证二叉搜索树;

import BinaryTree_二叉树.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/3
 * Time: 21:19
 * Description: https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class main {
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

    // 简洁实现·递归解法
    public boolean isValidBST2(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }

    // 迭代
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 左
                root = root.left;
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;
            // 右
            root = pop.right;
        }
        return true;
    }
}
