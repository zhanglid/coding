package com.zhangliang.pramp;

/*
*/
import java.io.*;
import java.util.*;

public class SodukoSolver {

    // 1. Check wether the current input is valid.
    // 2. Try to solve it by DFS.

    // Run dfs to get a solution. If it found a solution, it will return true.
    // Otherwise,
    // it will return false
    // Try each empty cell find empty cell i.e '.'. Try 1-9 to fit the cell.
    // If we cannot find empty cell, return true.
    private boolean dfs(List<Set<Integer>> rows, List<Set<Integer>> cols, List<List<Set<Integer>>> subBoards,
            List<int[]> emptyCells) {
        if (emptyCells.isEmpty()) {
            return true;
        }

        int[] pos = emptyCells.get(emptyCells.size() - 1);
        emptyCells.remove(emptyCells.size() - 1);
        for (int i = 1; i <= 9; i++) {
            if (!rows.get(pos[0]).contains(i) && !cols.get(pos[1]).contains(i)
                    && !subBoards.get(pos[0] / 3).get(pos[1] / 3).contains(i)) {
                rows.get(pos[0]).add(i);
                cols.get(pos[1]).add(i);
                subBoards.get(pos[0] / 3).get(pos[1] / 3).add(i);
                if (dfs(rows, cols, subBoards, emptyCells)) {
                    return true;
                }
                rows.get(pos[0]).remove(i);
                cols.get(pos[1]).remove(i);
                subBoards.get(pos[0] / 3).get(pos[1] / 3).remove(i);
            }
        }
        emptyCells.add(pos);
        return false;
    }

    // Assume board is 9x9 char 2-d array
    public boolean sudokuSolve(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        // Check each row, col and sub-board to see it it contains duplicated number.
        List<Set<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
        }
        List<Set<Integer>> cols = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cols.add(new HashSet<>());
        }
        List<List<Set<Integer>>> subBoards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            subBoards.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                subBoards.get(i).add(new HashSet<>());
            }
        }
        List<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new int[] { i, j });
                } else {
                    int value = board[i][j] - '0';
                    if (cols.get(j).contains(value) || rows.get(i).contains(value)
                            || subBoards.get(i / 3).get(j / 3).contains(value)) {
                        return false;
                    }
                    rows.get(i).add(value);
                    cols.get(j).add(value);
                    subBoards.get(i / 3).get(j / 3).add(value);
                }
            }
        }

        return dfs(rows, cols, subBoards, emptyCells);
    }

}
