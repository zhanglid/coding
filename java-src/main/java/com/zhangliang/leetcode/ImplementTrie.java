package com.zhangliang.leetcode;
/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

public class ImplementTrie {
    static class Trie {
        class Node {
            Node[] children = new Node[256];
            boolean hasWord = false;
        }

        Node head = new Node();

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = head;
            for (char x : word.toCharArray()) {
                if (cur.children[x] == null) {
                    cur.children[x] = new Node();
                }
                cur = cur.children[x];
            }
            cur.hasWord = true;
        }

        private Node findNode(String path) {
            Node cur = head;
            for (char x : path.toCharArray()) {
                if (cur.children[x] == null) {
                    return null;
                }
                cur = cur.children[x];
            }
            return cur;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = findNode(word);
            return node != null && node.hasWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node node = findNode(prefix);
            return node != null;
        }
    }
}
