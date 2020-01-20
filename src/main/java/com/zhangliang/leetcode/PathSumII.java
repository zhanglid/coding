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
    private void dfs(TreeNode root, List<Integer> path, int sum, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                result.add(new ArrayList<>(path));
                result.get(result.size() - 1).add(root.val);
            }
            return;
        }
        path.add(root.val);
        dfs(root.left, path, sum + root.val, target, result);
        dfs(root.right, path, sum + root.val, target, result);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), 0, sum, result);
        return result;
    }
}
