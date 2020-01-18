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
            this.max = max;
            this.min = min;
            this.isValid = isValid;
        }
    }

    private Result check(TreeNode node) {
        if (node == null) {
            return null;
        }
        Result l = check(node.left);
        Result r = check(node.right);
        int min = node.val;
        int max = node.val;
        boolean isValid = true;
        if (l != null) {
            min = Math.min(l.min, min);
            isValid = isValid && l.isValid && l.max < node.val;
        }
        if (r != null) {
            max = Math.max(r.max, max);
            isValid = isValid && r.isValid && r.min > node.val;
        }
        return new Result(min, max, isValid);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root).isValid;
    }
}
