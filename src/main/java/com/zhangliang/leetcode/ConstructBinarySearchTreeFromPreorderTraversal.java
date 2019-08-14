package com.zhangliang.leetcode;
/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a 
value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder 
traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
*/

import com.zhangliang.utils.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    private TreeNode helper(int[] preorder, int i, int j) {
        TreeNode node = new TreeNode(preorder[i]);
        if (i >= j) {
            return node;
        }
        int mid = i + 1;
        while (mid <= j && preorder[mid] < preorder[i]) {
            mid++;
        }
        if (mid > i + 1) {
            node.left = helper(preorder, i + 1, mid - 1);
        }
        if (mid <= j) {
            node.right = helper(preorder, mid, j);
        }
        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length < 1) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1);
    }
}
