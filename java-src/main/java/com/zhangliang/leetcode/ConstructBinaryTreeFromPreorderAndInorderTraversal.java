package com.zhangliang.leetcode;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

import com.zhangliang.utils.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private TreeNode buildTreeHelper(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij) {
        if (pi > pj) {
            return null;
        }
        int rootVal = preorder[pi];
        int rii = ii;
        while (inorder[rii] != rootVal) {
            rii++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, pi + 1, pi + (rii - ii), inorder, ii, rii - 1);
        root.right = buildTreeHelper(preorder, pi + (rii - ii) + 1, pj, inorder, rii + 1, ij);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
