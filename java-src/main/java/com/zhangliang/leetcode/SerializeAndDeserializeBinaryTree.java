package com.zhangliang.leetcode;
/*
Serialization is the process of converting a data structure or object into a sequence of 
bits so that it can be stored in a file or memory buffer, or transmitted across a network connection 
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can 
be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to 
follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms 
should be stateless.
*/

import java.util.*;
import com.zhangliang.utils.TreeNode;

public class SerializeAndDeserializeBinaryTree {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    static class Codec {
        private void levelScan(TreeNode node, List<Integer> result) {
            Queue<TreeNode> queue = new LinkedList<>();
            int nonNullSize = node == null ? 0 : 1;
            queue.add(node);
            while (!queue.isEmpty() && nonNullSize > 0) {
                TreeNode tn = queue.poll();
                result.add(tn == null ? null : tn.val);
                nonNullSize--;
                if (tn != null) {
                    queue.add(tn.left);
                    if (tn.left != null) {
                        nonNullSize = queue.size();
                    }
                    queue.add(tn.right);
                    if (tn.right != null) {
                        nonNullSize = queue.size();
                    }
                }
            }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            levelScan(root, result);
            return result.toString().replace(" ", "");
        }

        private TreeNode decodeToken(String token) {
            if (token.equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(token));
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1, data.length() - 1);
            if (data.length() < 1) {
                return null;
            }
            String[] tokens = data.split(",");
            if (tokens.length < 1) {
                return null;
            }
            TreeNode[] decodedTokens = new TreeNode[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                decodedTokens[i] = decodeToken(tokens[i]);
            }
            Queue<TreeNode> queue = new LinkedList<>();
            if (decodedTokens[0] == null) {
                return null;
            }
            int index = 0;
            queue.add(decodedTokens[index++]);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                node.left = index < decodedTokens.length ? decodedTokens[index++] : null;
                node.right = index < decodedTokens.length ? decodedTokens[index++] : null;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return decodedTokens[0];
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}
