package com.zhangliang.leetcode;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
*/

import com.zhangliang.utils.TreeNode;

public class ValidateBinarySearchTree {
    class ReturnType {
        int min;
        int max;
        boolean valid;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root).valid;
    }

    private ReturnType helper(TreeNode root) {
        ReturnType ans = new ReturnType();
        if (root == null) {
            return null;
        }

        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        ans.min = Math.min(root.val,
                Math.min(left == null ? Integer.MAX_VALUE : left.min, right == null ? Integer.MAX_VALUE : right.min));
        ans.max = Math.max(root.val,
                Math.max(left == null ? Integer.MIN_VALUE : left.max, right == null ? Integer.MIN_VALUE : right.max));

        ans.valid = (left == null || left.valid) && (right == null || right.valid)
                && (left == null || left.max < root.val) && (right == null || right.min > root.val);
        return ans;
    }
}
