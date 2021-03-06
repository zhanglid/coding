package com.zhangliang.leetcode;
/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling 
(a left node that shares the same parent node) or empty, flip it upside down and turn 
it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

Example:

Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1  
Clarification:

Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where 
no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
*/

import com.zhangliang.utils.TreeNode;

public class BinaryTreeUpsideDown {
    class ReturnType {
        TreeNode root;
        TreeNode tail;

        public ReturnType(TreeNode root, TreeNode tail) {
            this.root = root;
            this.tail = tail;
        }
    }

    private ReturnType helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        ReturnType r = helper(root.left);
        if (r == null) {
            r = new ReturnType(root, root);
        } else {
            r.tail.right = root;
            r.tail.left = root.right;
            r.tail = r.tail.right;
            r.tail.left = null;
            r.tail.right = null;
        }
        return r;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        ReturnType t = helper(root);
        return t == null ? null : t.root;
    }
}
