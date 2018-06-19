package com.zhangliang.leetcode;
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

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

import java.util.ArrayList;
import java.util.List;

import com.zhangliang.utils.TreeNode;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        helper(root, new ArrayList<>(), sum, ans);

        return ans;
    }

    private void helper(TreeNode root, List<Integer> curList, int sum, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            curList.add(root.val);
            ans.add(new ArrayList<>(curList));
            curList.remove(curList.size() - 1);
            return;
        }

        curList.add(root.val);
        sum -= root.val;
        helper(root.left, curList, sum, ans);
        helper(root.right, curList, sum, ans);
        curList.remove(curList.size() - 1);
    }
}
