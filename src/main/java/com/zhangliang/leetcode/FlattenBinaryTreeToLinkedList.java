package com.zhangliang.leetcode;
/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

import com.zhangliang.utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode leftEnd = root.left;

        while (leftEnd != null && leftEnd.right != null) {
            leftEnd = leftEnd.right;
        }

        if (leftEnd != null) {
            leftEnd.right = root.right;

            root.right = root.left;

            root.left = null;
        }
    }
}
