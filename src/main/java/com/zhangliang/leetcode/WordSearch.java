package com.zhangliang.leetcode;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those 
horizontally or vertically neighboring. The same letter cell may not be 
used more than once.

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
    private static final int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private int hash(int[] pos, int colNum) {
        return pos[0] * colNum + pos[1];
    }

    private boolean dfs(char[][] board, int[] pos, String word, int index, Set<Integer> visited) {
        int hashCode = hash(pos, board[0].length);
        if (visited.contains(hashCode) || board[pos[0]][pos[1]] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited.add(hashCode);
        for (int[] dir : dirs) {
            int[] next = new int[] { pos[0] + dir[0], pos[1] + dir[1] };
            if (next[0] < 0 || next[0] >= board.length || next[1] < 0 || next[1] >= board[0].length) {
                continue;
            }
            if (dfs(board, next, word, index + 1, visited)) {
                return true;
            }
        }
        visited.remove(hashCode);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, new int[] { i, j }, word, 0, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }
}
