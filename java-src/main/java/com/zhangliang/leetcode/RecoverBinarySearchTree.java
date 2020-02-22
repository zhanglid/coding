package com.zhangliang.leetcode;
/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class RecoverBinarySearchTree {
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void check(TreeNode root, List<TreeNode> list) {
        if (list.size() < 2) {
            list.add(root);
            return;
        }
        if (list.get(0).val < list.get(1).val) {
            list.remove(0);
            list.add(root);
        } else {
            if (root != null && root.val < list.get(1).val) {
                list.set(1, root);
            }
        }
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        check(root, list);
        inorder(root.right, list);
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        check(null, list);
        if (list.size() == 2 && list.get(1) != null) {
            swap(list.get(0), list.get(1));
        }
    }
}
