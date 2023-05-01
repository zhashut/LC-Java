package BinaryTree_二叉树.从前序与中序遍历序列构造二叉树;

import BinaryTree_二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/5/1
 * Time: 20:12
 * Description: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class main {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        // 用map保存中序序列的数值对应位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        // 不满足左闭右开，说明没有元素，返回空树
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }

        // 找到前序遍历的第一个元素在中序遍历中的位置
        int rootIndex = map.get(preorder[preBegin]);
        // 构造结点
        // 保存中序左子树个数，用来确定前序数列的个数
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1,
                inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}
