package com.zhangliang.google;
/*
给一个char stream, 有next(), 和hasNext(), 两个API。 给一些字符串作为目标字符串。要求每当 char 
stream里出现目标字符串任何一个词，就打印这个词。
比如目标 'abc, att, bba, bc, abce', 然后我们对char stream call next， 出来的一些char 是 t, a, 
b, c, e, t.... 我们需要打印 abc, bc, abce
这个题如果​把词典的word逆序后建Trie树​，再用一个vector存最近遇到的 max_length_of_word_in_dict个char，
每次来一个char就逆序构造string到Trie中查找
反着建的话，从stream尾到stream头O(n)遍历一遍就能找到所有match到的词。从stream头到 stream尾正着走的话，
要考虑到每一个字符都作为match开头的情况，所以要检查O(n^2)次。
例:
stream里已有aabca，新来一个字符t，变成aabcat。 字典里有"cat","bcat","aabcat"。
反建trie的话得到t->a->c (isWord) ->b (isWord) ->a->a (isWord)。 aabcat从后往前遍历一次在trie里
就能找到所有词。
*/

import java.util.ArrayList;
import java.util.List;

import com.zhangliang.google.IpAddressBlacklistMatching.Tire;

import ch.qos.logback.core.subst.Node;

public class FindStringMatchingFromStream {
    class Trie {
        class Node {
            Node[] nodes;
            boolean hasWord;
            String word;

            public Node() {
                this.nodes = new Node[26];
            }
        }

        Node root = new Node();

        public void insert(String word) {
            Node cur = root;
            for (char x : word.toCharArray()) {
                if (cur.nodes[x - 'a'] == null) {
                    cur.nodes[x - 'a'] = new Node();
                }
                cur = cur.nodes[x - 'a'];
            }
            cur.hasWord = true;
            cur.word = word;
        }

        public List<String> findAllMatchingWords(String prefix) {
            List<String> ans = new ArrayList<>();
            Node cur = root;
            for (char x : prefix.toCharArray()) {
                cur = cur.nodes[x - 'a'];
                if (cur == null) {
                    break;
                }
                if (cur.hasWord == true) {
                    ans.add(cur.word);
                }
            }

            return ans;
        }
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public List<String> solve(String[] words, String stream) {
        List<String> ans = new ArrayList<>();
        int maxlen = 0;
        Trie trie = new Trie();
        for (String str : words) {
            maxlen = Math.max(maxlen, str.length());
            trie.insert(reverse(str));
        }
        StringBuilder sb = new StringBuilder();
        for (char x : stream.toCharArray()) {
            if (sb.length() >= maxlen) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.insert(0, x);
            List<String> matches = trie.findAllMatchingWords(sb.toString());
            for (int i = matches.size() - 1; i >= 0; i--) {
                ans.add(reverse(matches.get(i)));
            }
        }

        return ans;
    }
}
