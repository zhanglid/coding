package com.zhangliang.leetcode;
/*
Given a binary tree, check whether it is a mirror of itself 
(ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class SymmetricTree {
    private boolean checkIsSymmetric(List<TreeNode> nodeList) {
        int r = nodeList.size() - 1;
        int l = 0;
        while (l < r) {
            if (nodeList.get(l) == null || nodeList.get(r) == null) {
                if (nodeList.get(l) != nodeList.get(r)) {
                    return false;
                }
            } else if (nodeList.get(l).val != nodeList.get(r).val) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            if (!checkIsSymmetric(level)) {
                return false;
            }
            int size = level.size();
            List<TreeNode> nextLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level.get(i) == null) {
                    continue;
                }
                nextLevel.add(level.get(i).left);
                nextLevel.add(level.get(i).right);
            }
            level = nextLevel;
        }
        return true;
    }
}
