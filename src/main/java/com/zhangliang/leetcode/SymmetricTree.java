package com.zhangliang.leetcode;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zhangliang.utils.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        if (root.left.val != root.right.val) {
            return false;
        }

        TreeNode dummy1 = new TreeNode(0);
        TreeNode dummy2 = new TreeNode(0);

        dummy1.left = root.left.left;
        dummy1.right = root.right.right;

        dummy2.left = root.left.right;
        dummy2.right = root.right.left;

        return isSymmetric(dummy1) && isSymmetric(dummy2);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<TreeNode> level = new LinkedList<>();
        level.add(root);

        while (!level.isEmpty()) {
            int size = level.size();
            int l = 0;
            int r = size - 1;
            while (l < r) {
                if (level.get(l) == null && level.get(r) != null || level.get(r) == null && level.get(l) != null
                        || level.get(l) != null && level.get(r) != null && level.get(l).val != level.get(r).val) {
                    return false;
                }
                l++;
                r--;
            }
            List<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node : level) {
                if (node == null) {
                    continue;
                }
                nextLevel.add(node.left);

                nextLevel.add(node.right);
            }

            level = nextLevel;
        }

        return true;
    }
}
