package com.zhangliang.leetcode;
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
*/

import com.zhangliang.utils.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    class Result {
        boolean hasP;
        boolean hasQ;
        TreeNode root;
    }

    private Result helper(TreeNode root, TreeNode p, TreeNode q) {
        Result result = new Result();
        if (root == null) {
            return result;
        }
        Result lr = helper(root.left, p, q);
        Result rr = helper(root.right, p, q);
        if (lr.root != null) {
            return lr;
        }
        if (rr.root != null) {
            return rr;
        }
        result.hasP = lr.hasP || rr.hasP || root.val == p.val;
        result.hasQ = lr.hasQ || rr.hasQ || root.val == q.val;
        if (result.hasP && result.hasQ) {
            result.root = root;
        }
        return result;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).root;
    }

}
