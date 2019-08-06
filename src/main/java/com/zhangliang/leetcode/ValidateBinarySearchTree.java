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

    class Result {
        int min;
        int max;
        boolean isValid;

        public Result(int min, int max, boolean isValid) {
            this.min = min;
            this.max = max;
            this.isValid = isValid;
        }
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        int min = root.val;
        int max = root.val;
        boolean isValid = true;
        Result left = helper(root.left);
        Result right = helper(root.right);

        if (left != null) {
            if (!left.isValid || left.max >= root.val) {
                isValid = false;
            } else {
                min = left.min;
            }
        }

        if (right != null) {
            if (!right.isValid || right.min <= root.val) {
                isValid = false;
            } else {
                max = right.max;
            }
        }

        return new Result(min, max, isValid);
    }

    public boolean isValidBST(TreeNode root) {
        Result result = helper(root);
        return result == null ? true : result.isValid;
    }

}
