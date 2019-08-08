package com.zhangliang.leetcode;
/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means 
it can represent any one letter.

Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.
*/

public class AddAndSearchWordDataStructureDesign {
    static class WordDictionary {

        class Tire {
            Tire[] children = new Tire[26];
            boolean hasWord;
        }

        class SearchResult {
            Tire last;
            int index;
        }

        private Tire head;

        private SearchResult searchTire(Tire cur, String s, int start) {
            SearchResult result = new SearchResult();
            result.last = cur;
            result.index = start - 1;
            for (int i = start; i < s.length() && cur != null; i++) {
                char x = s.charAt(i);
                if (x == '.') {
                    for (int j = 0; j < 26; j++) {
                        SearchResult sr = searchTire(cur.children[j], s, i + 1);
                        if (sr.index == s.length() - 1 && sr.last != null && sr.last.hasWord) {
                            return sr;
                        }
                    }
                    return result;
                } else {
                    Tire next = cur.children[x - 'a'];
                    if (next != null) {
                        result.last = next;
                        result.index = i;
                    }
                    cur = next;
                }
            }
            return result;
        }

        private void insert(Tire cur, String s, int start) {
            for (int i = start; i < s.length(); i++) {
                cur.children[s.charAt(i) - 'a'] = new Tire();
                cur = cur.children[s.charAt(i) - 'a'];
            }
            cur.hasWord = true;
        }

        /** Initialize your data structure here. */
        public WordDictionary() {
            head = new Tire();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            SearchResult sr = searchTire(head, word, 0);
            insert(sr.last, word, sr.index + 1);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            SearchResult sr = searchTire(head, word, 0);
            return sr.index == word.length() - 1 && sr.last.hasWord;
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
     * = obj.search(word);
     */
}
