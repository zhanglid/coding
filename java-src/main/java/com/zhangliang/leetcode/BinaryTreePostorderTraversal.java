package com.zhangliang.leetcode;
/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class BinaryTreePostorderTraversal {
    class NodeStatus {
        TreeNode root;
        boolean leftVisited;
        boolean rightVisited;

        public NodeStatus(TreeNode root) {
            this.root = root;
            leftVisited = false;
            rightVisited = false;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<NodeStatus> stack = new Stack<>();
        stack.push(new NodeStatus(root));
        while (!stack.isEmpty()) {
            NodeStatus nodeStatus = stack.peek();
            if (nodeStatus.leftVisited && nodeStatus.rightVisited) {
                result.add(nodeStatus.root.val);
                stack.pop();
            } else if (!nodeStatus.leftVisited) {
                nodeStatus.leftVisited = true;
                if (nodeStatus.root.left != null) {
                    stack.push(new NodeStatus(nodeStatus.root.left));
                }
            } else {
                nodeStatus.rightVisited = true;
                if (nodeStatus.root.right != null) {
                    stack.push(new NodeStatus(nodeStatus.root.right));
                }
            }
        }
        return result;
    }
}
