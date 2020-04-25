package com.zhangliang.leetcode;
/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
*/

import com.zhangliang.utils.*;

public class BinaryTreeLongestConsecutiveSequence {
    // [consecutive with root, longest consecutive in the subtree]
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int rootLength = 1;
        if (root.left != null && root.left.val == root.val + 1) {
            rootLength = Math.max(rootLength, 1 + left[0]);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            rootLength = Math.max(rootLength, 1 + right[0]);
        }
        int longestLen = Math.max(left[1], right[1]);
        longestLen = Math.max(longestLen, rootLength);
        return new int[] { rootLength, longestLen };
    }

    public int longestConsecutive(TreeNode root) {
        return helper(root)[1];
    }
}
