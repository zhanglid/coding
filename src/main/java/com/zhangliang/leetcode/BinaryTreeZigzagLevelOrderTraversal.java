package com.zhangliang.leetcode;
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, 
then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    private void pushNonNull(Stack<TreeNode> stack, TreeNode node) {
        if (node != null) {
            stack.push(node);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean forward = true;
        pushNonNull(stack, root);
        while (!stack.isEmpty()) {
            Stack<TreeNode> next = new Stack<>();
            List<Integer> level = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                level.add(node.val);
                if (forward) {
                    pushNonNull(next, node.left);
                    pushNonNull(next, node.right);
                } else {
                    pushNonNull(next, node.right);
                    pushNonNull(next, node.left);
                }
            }
            stack = next;
            forward = !forward;
            result.add(level);
        }

        return result;
    }
}
