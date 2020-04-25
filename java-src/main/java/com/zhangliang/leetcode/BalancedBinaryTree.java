package com.zhangliang.leetcode;
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*/

import com.zhangliang.utils.TreeNode;

public class BalancedBinaryTree {
    private class ReturnType {
        int height;
        boolean isBalanced;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root).isBalanced;
    }

    private ReturnType helper(TreeNode root) {
        ReturnType ans = new ReturnType();
        if (root == null) {
            ans.height = 0;
            ans.isBalanced = true;
            return ans;
        }

        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        ans.height = Math.max(left.height, right.height) + 1;

        ans.isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;

        return ans;
    }
}
