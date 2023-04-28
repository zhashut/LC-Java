package BinaryTree_二叉树.二叉树的最小深度;

import BinaryTree_二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/28
 * Time: 16:02
 * Description: https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class main {
    /**
     * 递归法
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        }
        if (root.left != null && root.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int minDepth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left == null && node.right == null) {
                    // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                    return minDepth;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }

        return minDepth;
    }
}
