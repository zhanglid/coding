package com.zhangliang.leetcode;
/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the 
root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

import java.util.Stack;

import com.zhangliang.utils.TreeNode;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        if (root != null)
            stack.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while (stack.peek().left != null) {
            TreeNode next = stack.peek().left();
            stack.peek().left = null;
            stack.push(next);
        }

        TreeNode node = stack.pop();
        if (node.right != null) {
            stack.push(node.right);
        }

        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */