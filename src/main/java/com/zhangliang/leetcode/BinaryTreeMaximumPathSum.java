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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum = root.val;
        helper(root);

        return maxSum;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val;
        int left = helper(root.left);
        int right = helper(root.right);

        if (left > 0) {
            sum += left;
        }

        if (right > 0) {
            sum += right;
        }

        maxSum = Math.max(maxSum, sum);

        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
