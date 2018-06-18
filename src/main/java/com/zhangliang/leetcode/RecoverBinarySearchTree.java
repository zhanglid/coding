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

import java.util.ArrayList;
import java.util.List;

import com.zhangliang.utils.TreeNode;

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        TreeNode target = null;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).val < list.get(i - 1).val && list.get(i).val < list.get(i + 1).val) {
                target = list.get(i);
            }
        }

        if (list.get(list.size() - 1).val < list.get(list.size() - 2).val) {
            target = list.get(list.size() - 1);
        }

        int index = 0;

        while (list.get(index).val < target.val) {
            index++;
        }

        int temp = list.get(index).val;
        list.get(index).val = target.val;
        target.val = temp;
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorder(root.left, list);
        }

        list.add(root);

        if (root.right != null) {
            inorder(root.right, list);
        }
    }
}
