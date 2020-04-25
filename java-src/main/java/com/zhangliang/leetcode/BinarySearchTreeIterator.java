package com.zhangliang.leetcode;
/*
Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class BinarySearchTreeIterator {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    static class BSTIterator {
        class Status {
            TreeNode root;
            boolean hasLeftVisited;
            boolean hasRightVisited;

            public Status(TreeNode root) {
                this.root = root;
                this.hasLeftVisited = root.left == null;
                this.hasRightVisited = root.right == null;
            }
        }

        Stack<Status> stack = new Stack<>();

        private void moveToSmallest() {
            while (!stack.peek().hasLeftVisited) {
                stack.peek().hasLeftVisited = true;
                stack.push(new Status(stack.peek().root.left));
            }
        }

        public BSTIterator(TreeNode root) {
            if (root != null) {
                stack.push(new Status(root));
                moveToSmallest();
            }
        }

        /** @return the next smallest number */
        public int next() {
            Status status = stack.pop();
            if (!status.hasRightVisited) {
                stack.push(new Status(status.root.right));
                moveToSmallest();
            }
            return status.root.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such: BSTIterator
     * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
     * obj.hasNext();
     */
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */