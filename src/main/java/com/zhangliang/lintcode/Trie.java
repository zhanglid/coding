package com.zhangliang.lintcode;
/*
442. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Example
insert("lintcode")
search("code")
>>> false
startsWith("lint")
>>> true
startsWith("linterror")
>>> false
insert("linterror")
search("lintcode)
>>> true
startsWith("linterror")
>>> true
Notice
You may assume that all inputs are consist of lowercase letters a-z.
*/

public class Trie {
    static class Node {
        public boolean isWordEnd;
        public Node[] children = new Node[26];
    }

    private Node root;

    public Trie() {
        // do intialization if necessary
        root = new Node();
    }

    /*
     * @param word: a word
     * 
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWordEnd = true;
    }

    /*
     * @param word: A string
     * 
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        Node cur = root;
        cur = moveToEnd(cur, word);
        return cur != null && cur.isWordEnd;
    }

    private Node moveToEnd(Node cur, String s) {
        for (char x : s.toCharArray()) {
            if (cur.children[x - 'a'] == null) {
                return null;
            }
            cur = cur.children[x - 'a'];
        }
        return cur;
    }

    /*
     * @param prefix: A string
     * 
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        Node cur = root;
        cur = moveToEnd(cur, prefix);
        return cur != null;
    }
}