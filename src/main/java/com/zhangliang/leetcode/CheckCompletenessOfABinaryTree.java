package com.zhangliang.leetcode;
/*
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes 
in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the 
last level h.

Example 1:
Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and 
all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:
Input: [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
 
Note:

The tree will have between 1 and 100 nodes.
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean hasNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean nextHasNull = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    if (nextHasNull) {
                        return false;
                    }
                    queue.add(node.left);
                } else {
                    nextHasNull = true;
                }
                if (node.right != null) {
                    if (nextHasNull) {
                        return false;
                    }
                    queue.add(node.right);
                } else {
                    nextHasNull = true;
                }
            }
            if (hasNull && !queue.isEmpty()) {
                return false;
            }
            hasNull = nextHasNull;
        }
        return true;
    }
}
