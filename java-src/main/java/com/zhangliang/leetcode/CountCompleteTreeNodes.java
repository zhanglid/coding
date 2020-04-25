package com.zhangliang.leetcode;
/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in 
the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*/

import com.zhangliang.utils.TreeNode;

/**
 * BinarySearch Time: O(logn * logn)
 */
public class CountCompleteTreeNodes {
    private boolean hasNode(TreeNode root, int path, int depth) {
        if (depth == 1) {
            return root != null;
        }
        if (root == null) {
            return false;
        }
        int value = path & (1 << (depth - 2));
        if (value == 0) {
            return hasNode(root.left, path, depth - 1);
        }
        return hasNode(root.right, path, depth - 1);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDepth(root.left) + 1;
    }

    public int countNodes(TreeNode root) {
        int depth = getDepth(root);
        if (depth == 0) {
            return 0;
        }
        int l = 0;
        int r = (1 << (depth - 1)) - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (hasNode(root, mid, depth)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        int lastIndex = hasNode(root, r, depth) ? r : l;
        return lastIndex + (1 << (depth - 1));
    }

}