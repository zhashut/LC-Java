package BinaryTree_二叉树.平衡二叉树;

import BinaryTree_二叉树.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/29
 * Time: 16:47
 * Description: https://leetcode.cn/problems/balanced-binary-tree/
 */
public class main {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getHeight(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

    /**
     * 优化迭代法，针对暴力迭代法的getHeight方法做优化，利用TreeNode.val来保存当前结点的高度，这样就不会有重复遍历
     * 获取高度算法时间复杂度可以降到O(1)，总的时间复杂度降为O(n)。
     * 时间复杂度：O(n)
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode inNode = stack.peek();
            // 右结点为null或已经遍历过
            if (inNode.right == null || inNode.right == pre) {
                // 输出
                if (Math.abs(getHeight2(inNode.left) - getHeight2(inNode.right)) > 1) {
                    return false;
                }
                stack.pop();
                pre = inNode;
                // 当前结点下，没有要遍历的结点了
                root = null;
            } else {
                // 右结点还没遍历，遍历右结点
                root = inNode.right;
            }
        }
        return true;
    }

    /**
     * 求结点的高度
     */
    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = root.left != null ? root.left.val : 0;
        int rightHeight = root.right != null ? root.right.val : 0;
        int height = Math.max(leftHeight, rightHeight) + 1;
        // 用TreeNode.val来保存当前结点的高度
        root.val = height;
        return height;
    }
}
