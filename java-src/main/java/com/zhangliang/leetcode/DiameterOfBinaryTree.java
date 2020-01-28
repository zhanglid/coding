package com.zhangliang.leetcode;
/*
Given a binary tree, you need to compute the length of the diameter of 
the tree. The diameter of a binary tree is the length of the longest 
path between any two nodes in a tree. This path may or may not pass 
through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number 
of edges between them.

*/

import com.zhangliang.utils.TreeNode;

public class DiameterOfBinaryTree {
    class Result {
        int longestToRoot;
        int longest;
    }

    private Result helper(TreeNode root) {
        Result r = new Result();
        if (root == null) {
            return r;
        }
        Result lr = helper(root.left);
        Result rr = helper(root.right);
        r.longest = 1;
        r.longestToRoot = 1 + Math.max(lr.longestToRoot, rr.longestToRoot);
        r.longest = Math.max(r.longest, rr.longest);
        r.longest = Math.max(r.longest, lr.longest);
        r.longest = Math.max(r.longest, 1 + lr.longestToRoot + rr.longestToRoot);
        return r;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(0, helper(root).longest - 1);
    }
}
