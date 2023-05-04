package BinaryTree_二叉树.二叉搜索树中的众数;

import BinaryTree_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/4
 * Time: 20:05
 * Description: https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 */
public class main {
    List<Integer> resList;
    int count;
    int maxCount;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        count = 0;
        maxCount = Integer.MIN_VALUE;
        pre = null;
        traversal(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }

        return res;
    }

    private void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre == null || cur.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            resList.clear();
            resList.add(cur.val);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(cur.val);
        }
        pre = cur;
        traversal(cur.right);
    }

    /**
     * 迭代法
     */
    public int[] findMode2(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int maxCount = 0;
        int count = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 计数
                if (pre == null || cur.val != pre.val) {
                    count = 1;
                } else {
                    count++;
                }
                // 更新结果
                if (count > maxCount) {
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                } else if (count == maxCount) {
                    result.add(cur.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
