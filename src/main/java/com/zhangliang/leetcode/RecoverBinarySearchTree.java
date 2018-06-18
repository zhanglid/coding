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

import com.zhangliang.utils.TreeNode;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return false;
        }
        if (min != null && root.val < min.val) {
            int temp = root.val;
            root.val = min.val;
            min.val = temp;
            return true;
        }

        if (max != null && root.val > max.val) {
            int temp = root.val;
            root.val = max.val;
            max.val = temp;
            return true;
        }

        if (helper(root.left, root, min)) {
            return true;
        }

        return helper(root.right, max, root);
    }
}
