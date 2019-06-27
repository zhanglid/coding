package com.zhangliang.leetcode;
/*
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, 
determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the 
similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" 
are similar, then "great" and "fine" are similar.

Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being 
similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs 
= [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] 
can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/

import java.util.*;

public class SentenceSimilarityII {
    class UnionFind {
        private Map<String, String> fathers = new HashMap<>();

        public UnionFind(List<String> nodes) {
            for (String node : nodes) {
                fathers.put(node, node);
            }
        }

        // Find the root.
        private String root(String node) {
            if (!fathers.containsKey(node)) {
                return node;
            }
            if (fathers.get(node).equals(node)) {
                return node;
            }
            String rootNode = root(fathers.get(node));
            fathers.put(node, rootNode);
            return rootNode;
        }

        public boolean isConnected(String a, String b) {
            if (a.equals(b)) {
                return true;
            }
            if (!fathers.containsKey(a) || !fathers.containsKey(b)) {
                return false;
            }
            return root(a).equals(root(b));
        }

        public void connect(String a, String b) {
            String rootA = root(a);
            String rootB = root(b);
            fathers.put(rootA, rootB);
        }
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Set<String> nodes = new HashSet<>();
        for (List<String> pair : pairs) {
            nodes.add(pair.get(0));
            nodes.add(pair.get(1));
        }
        UnionFind uf = new UnionFind(Arrays.asList(nodes.toArray(new String[0])));
        for (List<String> pair : pairs) {
            uf.connect(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (!uf.isConnected(word1, word2)) {
                return false;
            }
        }

        return true;
    }
}
