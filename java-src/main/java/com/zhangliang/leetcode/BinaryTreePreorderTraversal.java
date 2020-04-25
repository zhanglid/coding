package com.zhangliang.leetcode;
/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class BinaryTreePreorderTraversal {
    class NodeStatus {
        TreeNode root;
        boolean leftVisited;
        boolean rightVisited;

        public NodeStatus(TreeNode root) {
            this.root = root;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<NodeStatus> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(new NodeStatus(root));
        while (!stack.isEmpty()) {
            NodeStatus nodeStatus = stack.peek();
            if (!nodeStatus.leftVisited && !nodeStatus.rightVisited) {
                result.add(nodeStatus.root.val);
            }
            if (!nodeStatus.leftVisited) {
                nodeStatus.leftVisited = true;
                if (nodeStatus.root.left != null) {
                    stack.push(new NodeStatus(nodeStatus.root.left));
                }
            } else if (!nodeStatus.rightVisited) {
                nodeStatus.rightVisited = true;
                if (nodeStatus.root.right != null) {
                    stack.push(new NodeStatus(nodeStatus.root.right));
                }
            } else {
                stack.pop();
            }
        }
        return result;
    }
}
