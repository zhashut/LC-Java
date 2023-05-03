package BinaryTree_二叉树.二叉搜索树中的搜索;

import BinaryTree_二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/3
 * Time: 20:56
 * Description: https://leetcode.cn/problems/search-in-a-binary-search-tree/
 */
public class main {
    // 递归，普通二叉树
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST(root.right, val);
    }

    /**
     * // 递归，利用二叉搜索树特点，优化
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    /**
     * 层序遍历
     */
    public TreeNode searchBST3(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.val == val) {
                        return node.left;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == val) {
                        return node.right;
                    }
                    queue.offer(node.right);
                }
            }
        }

        return queue.poll();
    }
}
