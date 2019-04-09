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
import java.util.List;

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
                if (!children.get(i).isEqual(other)) {
                    return false;
                }
            }
            return true;
        }
    };

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {

        }
    }
}
