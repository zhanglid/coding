package com.zhangliang.leetcode;
/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you 
can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

*/

import java.util.ArrayList;
import java.util.List;

import com.zhangliang.utils.TreeNode;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        while (root != null) {
            ans.add(root.val);
            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return ans;
    }
}
