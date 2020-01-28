package com.zhangliang.leetcode;
/*
Given a non-empty binary search tree and a target value, find the value 
in the BST that is closest to the target.

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
        int result = root.val;
        if (root.left != null && (target < root.val)) {
            int lResult = closestValue(root.left, target);
            if (Math.abs(target - result) > Math.abs(lResult - target)) {
                result = lResult;
            }
        }
        if (root.right != null && (target > root.val)) {
            int rResult = closestValue(root.right, target);
            if (Math.abs(target - result) > Math.abs(rResult - target)) {
                result = rResult;
            }
        }
        return result;
    }
}
