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

        List<TreeNode> inorderList = getInOrderList(root);

        int index = 0;
        for (int i = 1; i < inorderList.size(); i++) {
            if (inorderList.get(i).val < inorderList.get(i - 1).val) {
                index = i;
            }
        }

        for (int i = 0; i < index; i++) {
            if (inorderList.get(i).val > inorderList.get(index).val) {
                int bigVal = inorderList.get(i).val;
                inorderList.get(i).val = inorderList.get(index).val;
                inorderList.get(index).val = bigVal;
                break;
            }
        }
    }

    private List<TreeNode> getInOrderList(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> left = getInOrderList(root.left);
        List<TreeNode> right = getInOrderList(root.right);

        left.add(root);
        left.addAll(right);
        return left;
    }
}
