package com.zhangliang.leetcode;
/*
Serialization is the process of converting a data structure or object into a sequence of 
bits so that it can be stored in a file or memory buffer, or transmitted across a network 
connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction 
on how your serialization/deserialization algorithm should work. You just need to ensure that 
a binary search tree can be serialized to a string and this string can be deserialized to 
the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and 
deserialize algorithms should be stateless.
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class SerializeAndDeserializeBst {
    // Definition for a binary tree node.
    // public class TreeNode {
    // int val;
    // TreeNode left;
    // TreeNode right;
    // TreeNode(int x) { val = x; }
    // }

    public static class Codec {
        private void preOrder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            preOrder(root.left, result);
            preOrder(root.right, result);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> preOrderResult = new ArrayList<>();
            preOrder(root, preOrderResult);
            return preOrderResult.toString();
        }

        private TreeNode build(int[] values, int start, int end) {
            if (end < start) {
                return null;
            }
            TreeNode root = new TreeNode(values[start]);
            int lEndIndex = start + 1;
            while (lEndIndex < values.length && values[lEndIndex] < root.val) {
                lEndIndex++;
            }
            root.left = build(values, start + 1, lEndIndex - 1);
            root.right = build(values, lEndIndex, end);
            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.replaceAll(" ", "");
            if (data.length() < 2) {
                return null;
            }
            data = data.substring(1, data.length() - 1);
            if (data.isEmpty()) {
                return null;
            }
            String[] tokens = data.split(",");
            int[] values = new int[tokens.length];
            for (int i = 0; i < values.length; i++) {
                values[i] = Integer.parseInt(tokens[i]);
            }
            return build(values, 0, values.length - 1);
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));}
}
