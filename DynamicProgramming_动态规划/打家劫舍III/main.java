package DynamicProgramming_动态规划.打家劫舍III;

import BinaryTree_二叉树.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/6/2
 * Time: 6:20
 * Description: https://leetcode.cn/problems/house-robber-iii/
 */
public class main {
    public int rob(TreeNode root) {
        int[] res = robTraversal(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robTraversal(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robTraversal(root.left);
        int[] right = robTraversal(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
