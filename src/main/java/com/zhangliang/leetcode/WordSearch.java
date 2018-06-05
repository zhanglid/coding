package com.zhangliang.leetcode;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

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

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1 || word == null || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Set<Integer> historyPos = new HashSet<>();
                historyPos.add(i * board[0].length + j);
                if (board[i][j] == word.charAt(0) && helper(board, word, 0, i, j, historyPos)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private boolean helper(char[][] board, String word, int cur, int si, int sj, Set<Integer> historyPosSet) {
        if (cur == word.length() - 1) {
            return true;
        }

        for (int[] dir : dirs) {
            int i = si + dir[0];
            int j = sj + dir[1];
            int key = i * board[0].length + j;
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !historyPosSet.contains(key)) {
                if (board[i][j] == word.charAt(cur + 1)) {
                    historyPosSet.add(key);
                    if (helper(board, word, cur + 1, i, j, historyPosSet)) {
                        return true;
                    }
                    historyPosSet.remove(key);
                }
            }
        }

        return false;
    }
}
