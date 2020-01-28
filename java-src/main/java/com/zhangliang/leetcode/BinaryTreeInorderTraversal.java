package com.zhangliang.leetcode;
/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class BinaryTreeInorderTraversal {
    class State {
        boolean isLeftVisited;
        TreeNode node;

        public State(TreeNode node) {
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<State> stack = new Stack<>();
        stack.push(new State(root));
        while (!stack.isEmpty()) {
            State state = stack.pop();
            if (!state.isLeftVisited) {
                state.isLeftVisited = true;
                stack.push(state);
                if (state.node.left != null) {
                    stack.push(new State(state.node.left));
                }
            } else {
                ans.add(state.node.val);
                if (state.node.right != null) {
                    stack.push(new State(state.node.right));
                }
            }
        }
        return ans;
    }
}
