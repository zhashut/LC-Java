package BinaryTree_二叉树.二叉搜索树的最小绝对差;

import BinaryTree_二叉树.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/4
 * Time: 18:27
 * Description: https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 */
public class main {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre != null) {
            result = Math.min(result, cur.val - pre.val);
        }
        pre = cur;
        traversal(cur.right);
    }

    /**
     * 迭代法-中序遍历
     */
    Stack<TreeNode> stack;

    public int getMinimumDifference2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 将访问的节点放进栈
                stack.push(cur);
                // 左
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 中
                if (pre != null) {
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                // 右
                cur = cur.right;
            }
        }
        return result;
    }
}
