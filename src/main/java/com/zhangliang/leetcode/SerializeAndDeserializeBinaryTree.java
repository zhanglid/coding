package com.zhangliang.leetcode;
/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored 
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or 
another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a 
string and this string can be deserialized to the original tree structure.

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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                result.add(node == null ? null : node.val);
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            while (!result.isEmpty() && result.get(result.size() - 1) == null) {
                result.remove(result.size() - 1);
            }
            return result.toString();
        }

        private TreeNode decode(String part) {
            if (part.equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(part));
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.replace(" ", "");
            data = data.replace("[", "");
            data = data.replace("]", "");
            String[] parts = data.split(",");
            if (data.equals("")) {
                return null;
            }
            TreeNode root = decode(parts[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            for (int i = 1; i < parts.length; i++) {
                TreeNode node = queue.poll();
                node.left = decode(parts[i]);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (i + 1 < parts.length) {
                    i++;
                    node.right = decode(parts[i]);
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}
