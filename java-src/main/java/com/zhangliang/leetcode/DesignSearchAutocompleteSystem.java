package com.zhangliang.leetcode;
/*
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a 
special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences 
that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences 
have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences 
is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. 
Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case 
letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be 
recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part 
of sentence already typed.

 
Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. 
Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we 
only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following 
input will be counted as a new search.

 
Note:

The input sentence will always start with a letter and end with '#', and only one blank space will exist between two 
words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in 
the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are 
persisted across multiple test cases. Please see here for more details.
 
*/

import java.util.*;

public class DesignSearchAutocompleteSystem {
    public static class AutocompleteSystem {
        class TrieNode {
            String value;
            TrieNode[] children = new TrieNode[256];
            List<String> descendants = new ArrayList<>();
        }

        class Trie {
            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String s) {
                TrieNode cur = root;
                for (char c : s.toCharArray()) {
                    cur.descendants.add(s);
                    if (cur.children[c] == null) {
                        cur.children[c] = new TrieNode();
                    }
                    cur = cur.children[c];
                }
                cur.value = s;
                cur.descendants.add(s);
            }

            public TrieNode findNode(String s) {
                TrieNode cur = root;
                for (char c : s.toCharArray()) {
                    if (cur.children[c] == null) {
                        return null;
                    }
                    cur = cur.children[c];
                }

                return cur;
            }

            public void refreshOrder(String s, Comparator<String> cmpr) {
                TrieNode cur = root;
                for (char c : s.toCharArray()) {
                    Collections.sort(cur.descendants, cmpr);
                    cur = cur.children[c];
                }
                Collections.sort(cur.descendants, cmpr);
            }
        }

        private Trie words;
        private Map<String, Integer> counts;
        private StringBuilder currentInput;
        private TrieNode currentTrieNode;

        private Comparator<String> getComparator() {
            return new Comparator<String>() {
                public int compare(String a, String b) {
                    int countDiff = counts.get(b) - counts.get(a);
                    if (countDiff == 0) {
                        return a.compareTo(b);
                    }
                    return countDiff;
                }
            };
        }

        private void closeSentence() {
            if (currentInput.length() > 0) {
                String target = currentInput.toString();
                if (!counts.containsKey(target)) {
                    words.insert(target);
                }
                counts.put(target, counts.getOrDefault(target, 0) + 1);
                words.refreshOrder(target, this.getComparator());
            }
            currentInput = new StringBuilder();
            currentTrieNode = words.root;
        }

        public AutocompleteSystem(String[] sentences, int[] times) {
            currentInput = new StringBuilder();
            counts = new HashMap<>();
            words = new Trie();
            for (int i = 0; i < sentences.length; i++) {
                counts.put(sentences[i], times[i]);
                words.insert(sentences[i]);
            }
            for (String s : sentences) {
                words.refreshOrder(s, this.getComparator());
            }
            currentTrieNode = words.root;
        }

        public List<String> input(char c) {
            if (c == '#') {
                closeSentence();
                return new ArrayList<>();
            }
            currentInput.append(c);
            if (currentTrieNode != null) {
                currentTrieNode = currentTrieNode.children[c];
                if (currentTrieNode != null) {
                    return currentTrieNode.descendants.subList(0, Math.min(3, currentTrieNode.descendants.size()));
                }
            }
            return new ArrayList<>();
        }
    }
}
