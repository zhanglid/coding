package com.zhangliang.leetcode;
/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    class Tire {
        class Node {
            public boolean isWordEnd;
            public Node[] children = new Node[26];
        }

        private Node root;

        public Tire() {
            root = new Node();
        }

        public void insert(String s) {
            Node cur = root;

            for (char x : s.toCharArray()) {
                if (cur.children[x - 'a'] == null) {
                    cur.children[x - 'a'] = new Node();
                }

                cur = cur.children[x - 'a'];
            }
            cur.isWordEnd = true;
        }

        private Node move(Node cur, String s) {
            for (char x : s.toCharArray()) {
                if (cur.children[x - 'a'] == null) {
                    return null;
                }
                cur = cur.children[x - 'a'];
            }

            return cur;
        }

        public boolean startWith(String s) {
            Node cur = root;
            cur = move(cur, s);
            return cur != null;
        }

        public boolean hasWord(String s) {
            Node cur = root;
            cur = move(cur, s);
            return cur != null && cur.isWordEnd;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();

        Tire tire = new Tire();
        for (String s : words) {
            tire.insert(s);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Set<Integer> visited = new HashSet<>();
                visited.add(i * board[0].length + j);
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                helper(i, j, visited, board, tire, sb, ans);
            }
        }

        return new ArrayList<>(ans);
    }

    private static int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    private void helper(int i, int j, Set<Integer> visited, char[][] board, Tire tire, StringBuilder path,
            Set<String> ans) {
        if (tire.hasWord(path.toString())) {
            ans.add(path.toString());
        }
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length
                    || !tire.startWith(path.toString() + board[ni][nj])
                    || visited.contains(ni * board[0].length + nj)) {
                continue;
            }
            path.append(board[ni][nj]);
            visited.add(ni * board[0].length + nj);
            helper(ni, nj, visited, board, tire, path, ans);
            visited.remove(ni * board[0].length + nj);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
