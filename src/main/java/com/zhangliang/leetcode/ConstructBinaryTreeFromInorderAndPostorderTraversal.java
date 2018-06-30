package com.zhangliang.leetcode;
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

import java.util.HashMap;
import java.util.Map;

import com.zhangliang.utils.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1
                || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            orderMap.put(postorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, orderMap);
    }

    private TreeNode helper(int[] inorder, int start, int end, Map<Integer, Integer> orderMap) {
        if (start > end) {
            return null;
        }

        int rootIndex = start;
        for (int i = start; i <= end; i++) {
            if (orderMap.get(inorder[i]) > orderMap.get(inorder[rootIndex])) {
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = helper(inorder, start, rootIndex - 1, orderMap);
        root.right = helper(inorder, rootIndex + 1, end, orderMap);

        return root;
    }
}
