package BinaryTree_二叉树.把二叉搜索树转换为累加树;

import BinaryTree_二叉树.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/7
 * Time: 21:40
 * Description: https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */
public class main {
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    private void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
    }
}
