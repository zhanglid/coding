package com.zhangliang.leetcode;
/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

import java.util.ArrayList;
import java.util.List;
import com.zhangliang.utils.TreeNode;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();

        if (n < 1) {
            return ans;
        }

        List<List<TreeNode>> dp = new ArrayList<>();
        List<TreeNode> initailList = new ArrayList<>();
        initailList.add(null);
        dp.add(initailList);
        for (int i = 1; i <= n; i++) {
            List<TreeNode> curList = new ArrayList<>();
            for (int m = 1; m <= i; m++) {
                // right
                int r = i - m;
                int l = m - 1;
                for (TreeNode ltree : dp.get(l)) {
                    for (TreeNode rtree : dp.get(r)) {
                        TreeNode root = new TreeNode(m);
                        root.right = getOffsetTree(rtree, m);
                        root.left = ltree;
                        curList.add(root);
                    }
                }
            }

            dp.add(curList);
        }

        return dp.get(n);
    }

    private TreeNode getOffsetTree(TreeNode root, int offset) {
        if (root == null) {
            return root;
        }

        TreeNode newRoot = new TreeNode(root.val + offset);

        newRoot.left = getOffsetTree(root.left, offset);
        newRoot.right = getOffsetTree(root.right, offset);

        return newRoot;
    }
}
