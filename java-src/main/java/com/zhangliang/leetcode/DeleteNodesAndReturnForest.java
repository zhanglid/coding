package com.zhangliang.leetcode;
/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example 1:
       1
     /   \
    2     3
   / \   / \
  4   5 6   7

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
*/

import java.util.*;

import com.zhangliang.utils.*;

public class DeleteNodesAndReturnForest {
    private TreeNode delHelper(TreeNode root, Set<Integer> numsToDel, List<TreeNode> result) {
        if (root == null) {
            return null;
        }
        root.left = delHelper(root.left, numsToDel, result);
        root.right = delHelper(root.right, numsToDel, result);
        if (numsToDel.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> numsToDel = new HashSet<>();
        for (int num : to_delete) {
            numsToDel.add(num);
        }
        TreeNode newRoot = delHelper(root, numsToDel, result);
        if (newRoot != null) {
            result.add(newRoot);
        }
        return result;
    }
}
