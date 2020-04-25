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
    private int helper(TreeNode root, int[] preorder, int index, int maxValue) {
        int next = index + 1;
        if (next >= preorder.length) {
            return next;
        }
        if (preorder[next] < preorder[index]) {
            root.left = new TreeNode(preorder[next]);
            next = helper(root.left, preorder, next, root.val);
        }

        if (next < preorder.length && preorder[next] <= maxValue) {
            root.right = new TreeNode(preorder[next]);
            next = helper(root.right, preorder, next, maxValue);
        }
        return next;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        helper(root, preorder, 0, Integer.MAX_VALUE);
        return root;
    }
}
