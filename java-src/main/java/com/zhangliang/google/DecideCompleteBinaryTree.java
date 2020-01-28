package com.zhangliang.google;
/*
判断一个binary tree是complete binary tree
In a complete binary tree every level, except possibly the last, is 
completely filled, and all nodes in the last level are as far left as 
possible. It can have between 1 and 2h nodes inclusive at the last level 
h.
isFull(TreeNode) and isComplete(TreeNode)

类似222. Count Complete Tree Nodes
用level order traversal判断?将null也进队列，如果在队列中遇到null了，则读取queue中
剩余所 有元素，全都为null即为complete tree。
Follow-up: 给一个sorted array， construct complete binary tree.
*/

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.zhangliang.utils.TreeNode;

public class DecideCompleteBinaryTree {
    class Rtn {
        int min;
        int max;
        boolean isValid;
    }

    public boolean isComplete(TreeNode root) {
        if (!isBinaryTree(root).isValid) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                break;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }

        return true;
    }

    public Rtn isBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Rtn ans = new Rtn();
        Rtn left = isBinaryTree(root.left);
        Rtn right = isBinaryTree(root.right);
        if (left != null && left.isValid == false || right != null && right.isValid == false) {
            ans.isValid = false;
            return ans;
        }

        if (left != null && left.max >= root.val) {
            ans.isValid = false;
            return ans;
        }

        if (right != null && right.min <= root.val) {
            ans.isValid = false;
            return ans;
        }

        ans.min = left == null ? root.val : left.min;
        ans.max = right == null ? root.val : right.max;
        ans.isValid = true;
        return ans;
    }
}
