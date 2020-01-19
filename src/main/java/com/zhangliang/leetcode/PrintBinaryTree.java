package com.zhangliang.leetcode;
/*
Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly 
middle of the first row it can be put. The column and the row where 
the root node belongs will separate the rest space into two parts 
(left-bottom part and right-bottom part). You should print the left 
subtree in the left-bottom part and print the right subtree in 
the right-bottom part. The left-bottom part and the right-bottom part 
should have the same size. Even if one subtree is none while the other 
is not, you don't need to print anything for the none subtree 
but still need to leave the space as large as that for the other subtree. 
However, if two subtrees are none, then you don't need to leave space 
for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.

Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]

Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]

Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class PrintBinaryTree {
    private int getWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getWidth(root.left), getWidth(root.right)) * 2 + 1;
    }

    private int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    private void build(TreeNode root, int center, int width, int index, List<List<String>> result) {
        if (root == null) {
            return;
        }
        List<String> level = result.get(index);
        level.set(center, Integer.toString(root.val));
        int nextWidth = (width - 1) / 2;
        build(root.left, center - (nextWidth - 1) / 2 - 1, nextWidth, index + 1, result);
        build(root.right, center + (nextWidth - 1) / 2 + 1, nextWidth, index + 1, result);
    }

    public List<List<String>> printTree(TreeNode root) {
        int width = getWidth(root);
        int depth = getDepth(root);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            List<String> level = new ArrayList<>();
            result.add(level);
            for (int j = 0; j < width; j++) {
                level.add("");
            }
        }
        build(root, width / 2, width, 0, result);
        return result;
    }
}
