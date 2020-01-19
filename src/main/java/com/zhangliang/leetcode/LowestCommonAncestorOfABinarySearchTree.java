package com.zhangliang.leetcode;
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]


 

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 

Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.
*/

import com.zhangliang.utils.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    class ReturnType {
        boolean foundP;
        boolean foundQ;
        TreeNode result;
    }

    private ReturnType helper(TreeNode root, TreeNode p, TreeNode q) {
        ReturnType ans = new ReturnType();
        if (root == null) {
            return ans;
        }
        ReturnType lt = helper(root.right, p, q);
        ReturnType rt = helper(root.left, p, q);

        ans.foundP = lt.foundP || rt.foundP || root.val == p.val;
        ans.foundQ = lt.foundQ || rt.foundQ || root.val == q.val;
        if (lt.result != null) {
            ans.result = lt.result;
        } else if (rt.result != null) {
            ans.result = rt.result;
        } else if (ans.foundP && ans.foundQ) {
            ans.result = root;
        }
        return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ReturnType rt = helper(root, p, q);
        return rt.foundP && rt.foundQ ? rt.result : null;
    }
}
