package com.zhangliang.leetcode;
/*
Serialization is the process of converting a data structure or object 
into a sequence of bits so that it can be stored in a file or memory 
buffer, or transmitted across a network connection link to be 
reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. 
An N-ary tree is a rooted tree in which each node has no more than N 
children. There is no restriction on how your 
serialization/deserialization algorithm should work. You just need to 
ensure that an N-ary tree can be serialized to a string and this string 
can be deserialized to the original tree structure.

For example, you may serialize the following 3-ary tree

as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, 
so please be creative and come up with different approaches yourself.

Note:

N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. Your 
serialize and deserialize algorithms should be stateless.
*/

import java.util.*;

/*
// Definition for a Node.

*/

public class SerializeAndDeserializeNAryTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        public boolean isEqual(Node other) {
            if (other == null) {
                return false;
            }
            if (val != other.val) {
                return false;
            }
            ;
            if (children.size() != other.children.size()) {
                return false;
            }
            for (int i = 0; i < children.size(); i++) {
                if (!children.get(i).isEqual(other.children.get(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    /*
     * // Definition for a Node. class Node { public int val; public List<Node>
     * children;
     * 
     * public Node() {}
     * 
     * public Node(int _val) { val = _val; }
     * 
     * public Node(int _val, List<Node> _children) { val = _val; children =
     * _children; } };
     */
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) {
                return "";
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            List<String> levels = new ArrayList<>();
            while (!queue.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(node.val + "#" + node.children.size());
                    for (Node child : node.children) {
                        queue.add(child);
                    }
                }
                levels.add(sb.toString());
            }
            return String.join("\n", levels);
        }

        private Node fromToken(String token) {
            if (token.length() < 1) {
                return null;
            }
            String[] parts = token.split("#");
            Node node = new Node(Integer.parseInt(parts[0]));
            int childrenSize = Integer.parseInt(parts[1]);
            node.children = new ArrayList<>();
            for (int i = 0; i < childrenSize; i++) {
                node.children.add(null);
            }
            return node;
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.length() < 1) {
                return null;
            }
            String[] levelTokens = data.split("\n");
            if (levelTokens.length < 1) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            Node root = fromToken(levelTokens[0]);
            queue.add(root);
            int level = 1;
            while (!queue.isEmpty() && level < levelTokens.length) {
                int tokenIndex = 0;
                String[] tokens = levelTokens[level++].split(",");
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    for (int j = 0; j < node.children.size(); j++) {
                        node.children.set(j, fromToken(tokens[tokenIndex++]));
                        queue.add(node.children.get(j));
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
