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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
// Definition for a Node.

*/

public class SerializeAndDeserializeNAryTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            this.children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        public boolean isEqual(Node other) {
            if (other == null || val != other.val) {
                return false;
            }
            if (children == other.children) {
                return true;
            }
            if (other.children.size() != children.size()) {
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

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            Queue<Node> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            List<String> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                list.add(node.val + "," + node.children.size());
                for (Node child : node.children) {
                    queue.add(child);
                }
            }

            return String.join("#", list);
        }

        private Node decode(String part) {
            String[] data = part.split(",");
            int size = Integer.parseInt(data[1]);
            return new Node(Integer.parseInt(data[0]), Arrays.asList(new Node[size]));
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            Node root = null;
            if (data.equals("")) {
                return null;
            }
            String[] parts = data.split("#");
            if (parts.length < 1) {
                return root;
            }
            root = decode(parts[0]);
            Queue<Node> nodesToFill = new LinkedList<>();
            nodesToFill.add(root);
            int index = 1;
            while (index < parts.length) {
                Node node = nodesToFill.poll();
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = decode(parts[index++]);
                    nodesToFill.add(child);
                    node.children.set(i, child);
                }

            }

            return root;
        }
    }
}
