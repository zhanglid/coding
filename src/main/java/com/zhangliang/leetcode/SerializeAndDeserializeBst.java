package com.zhangliang.leetcode;
/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored 
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or 
another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your 
serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be 
serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms 
should be stateless.
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class SerializeAndDeserializeBst {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> valueList = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
                valueList.add(root.val);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    valueList.add(node.left == null ? null : node.left.val);
                    valueList.add(node.right == null ? null : node.right.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return valueList.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.replaceAll(" ", "");
            data = data.substring(1, data.length() - 1);
            String[] strs = data.split(",");
            if (strs.length < 1 || data.length() < 1) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode node = root;
            boolean isLeft = true;
            for (int i = 1; i < strs.length; i++) {
                TreeNode child = strs[i].equals("null") ? null : new TreeNode(Integer.parseInt(strs[i]));
                if (isLeft) {
                    node = queue.peek();
                    node.left = child;
                    isLeft = false;
                } else {
                    node = queue.poll();
                    node.right = child;
                    isLeft = true;
                }
                if (child != null) {
                    queue.add(child);
                }
            }
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}
