package BinaryTree_二叉树.删除二叉搜索树中的节点;

import BinaryTree_二叉树.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/6
 * Time: 21:41
 * Description: https://leetcode.cn/problems/delete-node-in-a-bst/
 */
public class main {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            root.val = tmp.val;
            root.right = deleteNode(root.right, tmp.val);
        }

        return root;
    }
}
