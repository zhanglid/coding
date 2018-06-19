package com.zhangliang.leetcode;
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
*/

import com.zhangliang.utils.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == -1) {
            return right + 1;
        }

        if (right == -1) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }
}