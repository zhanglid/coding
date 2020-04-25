package com.zhangliang.leetcode;
/*
Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried 
(in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 

Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.
*/

import java.util.*;

public class StreamOfCharacters {
    static class StreamChecker {
        class Trie {
            class Node {
                Node[] children = new Node[256];
                boolean hasWord = false;
            }

            Node head = new Node();

            public void addWord(String word) {
                Node node = head;
                for (char x : word.toCharArray()) {
                    if (node.children[x] == null) {
                        node.children[x] = new Node();
                    }
                    node = node.children[x];
                }
                node.hasWord = true;
            };

            public boolean hasWordOnPath(List<Character> path) {
                Node node = head;
                for (char x : path) {
                    if (node.children[x] == null) {
                        return false;
                    }
                    node = node.children[x];
                    if (node.hasWord) {
                        return true;
                    }
                }
                return false;
            };
        }

        Trie trie = new Trie();
        LinkedList<Character> buffer = new LinkedList<>();

        public StreamChecker(String[] words) {
            for (String word : words) {
                StringBuilder sb = new StringBuilder(word);
                sb.reverse();
                trie.addWord(sb.toString());
            }
        }

        public boolean query(char letter) {
            buffer.addFirst(letter);
            return trie.hasWordOnPath(buffer);
        }
    }
}
