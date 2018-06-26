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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhangliang.utils.TreeNode;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (stack.peek().left != null) {
                TreeNode left = stack.peek().left;
                stack.peek().left = null;
                stack.push(left);
            } else if (stack.peek().right != null) {
                TreeNode right = stack.peek().right;
                stack.peek().right = null;
                stack.push(right);
            } else {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
            }
        }

        return ans;
    }
}
