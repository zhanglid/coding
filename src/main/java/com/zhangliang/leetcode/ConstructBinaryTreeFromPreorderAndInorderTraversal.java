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

import java.util.HashMap;
import java.util.Map;

import com.zhangliang.utils.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(preorder[i], i);
        }

        return helper(inorder, 0, inorder.length, indexMap);
    }

    private TreeNode helper(int[] inorder, int start, int end, Map<Integer, Integer> indexDict) {
        if (start >= end) {
            return null;
        }
        int rootIndex = start;
        for (int i = start; i < end; i++) {
            if (indexDict.get(inorder[i]) < indexDict.get(inorder[rootIndex])) {
                rootIndex = i;
            }
        }

        TreeNode ans = new TreeNode(inorder[rootIndex]);
        ans.left = helper(inorder, start, rootIndex, indexDict);
        ans.right = helper(inorder, rootIndex + 1, end, indexDict);

        return ans;
    }
}
