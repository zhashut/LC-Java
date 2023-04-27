package BinaryTree_二叉树.翻转二叉树;

import BinaryTree_二叉树.TreeNode;

import java.util.ArrayDeque;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/27
 * Time: 19:54
 * Description: https://leetcode.cn/problems/invert-binary-tree/
 */
public class main {
    // 前序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(root.val);
        treeNode.left = invertTree(root.right);
        treeNode.right = invertTree(root.left);

        return treeNode;
    }

    // BFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }

        return root;
    }

    private void swap(TreeNode node) {
        TreeNode tmpNode = node.left;
        node.left = node.right;
        node.right = tmpNode;
    }
}
