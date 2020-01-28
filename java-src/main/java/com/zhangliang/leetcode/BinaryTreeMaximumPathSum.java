package com.zhangliang.leetcode;
/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree 
along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
*/

import com.zhangliang.utils.TreeNode;

public class BinaryTreeMaximumPathSum {

    // [maxSum, maxToRoot]
    private int[] helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int maxToRoot = 0;
        int sumWithRoot = root.val;
        int maxSum = root.val;
        if (left != null) {
            if (left[1] > 0) {
                sumWithRoot += left[1];
            }
            maxToRoot = Math.max(maxToRoot, left[1]);
            maxSum = Math.max(maxSum, left[0]);
        }
        if (right != null) {
            if (right[1] > 0) {
                sumWithRoot += right[1];
            }
            maxToRoot = Math.max(maxToRoot, right[1]);
            maxSum = Math.max(maxSum, right[0]);
        }
        maxToRoot += root.val;
        return new int[] { Math.max(maxSum, sumWithRoot), maxToRoot };
    }

    public int maxPathSum(TreeNode root) {
        int[] ans = helper(root);
        return ans == null ? 0 : ans[0];
    }
}
