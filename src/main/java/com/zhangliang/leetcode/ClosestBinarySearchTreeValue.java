package com.zhangliang.leetcode;
/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest 
to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
*/

import com.zhangliang.utils.TreeNode;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int value = root.val;
        if (root.left != null) {
            int other = closestValue(root.left, target);
            if (Math.abs(value - target) > Math.abs(other - target)) {
                value = other;
            }
        }
        if (root.right != null) {
            int other = closestValue(root.right, target);
            if (Math.abs(value - target) > Math.abs(other - target)) {
                value = other;
            }
        }
        return value;
    }
}
