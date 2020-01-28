package com.zhangliang.leetcode;
/*
Given a binary tree and a sum, find all root-to-leaf paths where 
each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class PathSumII {
    private void dfs(TreeNode node, List<Integer> path, int sum, int target, List<List<Integer>> result) {
        path.add(node.val);
        sum += node.val;
        if (node.left == null && node.right == null && sum == target) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        if (node.left != null) {
            dfs(node.left, path, sum, target, result);
        }
        if (node.right != null) {
            dfs(node.right, path, sum, target, result);
        }
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            dfs(root, new ArrayList<>(), 0, sum, result);
        }
        return result;
    }
}
