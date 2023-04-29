package BinaryTree_二叉树.完全二叉树的节点个数;

import BinaryTree_二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/28
 * Time: 16:27
 * Description: https://leetcode.cn/problems/count-complete-tree-nodes/submissions/
 */
public class main {
    /**
     * 递归法
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }

    /**
     * 迭代法
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                result++;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return result;
    }
}
