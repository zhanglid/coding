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
        if (inorder == null || inorder.length < 1 || postorder == null || postorder.length < 1
                || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return helper(inorder, 0, inorder.length, map);
    }

    private TreeNode helper(int[] inorder, int start, int end, Map<Integer, Integer> dict) {
        if (start >= end) {
            return null;
        }
        int rootIndex = start;
        for (int i = start; i < end; i++) {
            if (dict.get(inorder[i]) > dict.get(inorder[rootIndex])) {
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(inorder[rootIndex]);

        root.left = helper(inorder, start, rootIndex, dict);
        root.right = helper(inorder, rootIndex + 1, end, dict);

        return root;
    }
}
