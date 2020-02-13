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
    static class AutocompleteSystem {
        class Node {
            class Sentence {
                String text;
                int count;

                public Sentence(String text, int count) {
                    this.text = text;
                    this.count = count;
                }
            }

            public Node[] children = new Node[256];
            public int count = 0;

            List<Sentence> sentenceList = new ArrayList<>();

            public List<String> getSentences() {
                List<String> result = new ArrayList<>();
                for (Sentence s : sentenceList) {
                    result.add(s.text);
                }
                return result;
            }

            public void addSentence(String text, int count) {
                boolean has = false;
                for (Sentence s : sentenceList) {
                    if (s.text.equals(text)) {
                        has = true;
                        s.count = count;
                        break;
                    }
                }
                if (!has) {
                    sentenceList.add(new Sentence(text, count));
                }
                Collections.sort(sentenceList, new Comparator<Sentence>() {
                    public int compare(Sentence a, Sentence b) {
                        int countDiff = b.count - a.count;
                        if (countDiff == 0) {
                            return a.text.compareTo(b.text);
                        }
                        return countDiff;
                    }
                });
                if (sentenceList.size() > 3) {
                    sentenceList.remove(3);
                }
            }
        }

        Node head = new Node();
        StringBuilder sb = new StringBuilder();
        Node cur = head;

        private void insert(String text, int time) {
            Node node = head;
            node.addSentence(text, time);
            for (char x : text.toCharArray()) {
                if (node.children[x] == null) {
                    node.children[x] = new Node();
                }
                node.children[x].addSentence(text, time);
                node = node.children[x];
            }
            node.count = time;
        }

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                String s = sentences[i];
                int time = times[i];
                insert(s, time);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                if (sb.length() > 0) {
                    insert(sb.toString(), cur.count + 1);
                    sb = new StringBuilder();
                    cur = head;
                }
                return new ArrayList<>();
            }
            sb.append(c);
            if (cur.children[c] == null) {
                cur.children[c] = new Node();
            }
            cur = cur.children[c];
            return cur.getSentences();
        }
    }
}
