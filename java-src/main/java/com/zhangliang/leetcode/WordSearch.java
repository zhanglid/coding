package com.zhangliang.leetcode;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

import java.util.*;

public class WordSearch {
    private int hash(int i, int j, char[][] board) {
        return j + i * board[0].length;
    }

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private boolean dfs(char[][] board, int i, int j, int start, String word, Set<Integer> visited) {
        if (start >= word.length()) {
            return false;
        }
        int key = hash(i, j, board);
        if (visited.contains(key)) {
            return false;
        }
        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        if (start == word.length() - 1) {
            return true;
        }
        visited.add(key);
        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) {
                continue;
            }
            if (dfs(board, ni, nj, start + 1, word, visited)) {
                return true;
            }
        }
        visited.remove(key);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }
}
