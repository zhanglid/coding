package com.zhangliang.leetcode;
/*
Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an 
unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, 
and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and 
finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the 
board after revealing this position according to the following rules:


If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its 
adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') 
representing the number of adjacent mines.
Return the board when no more squares will be revealed.

Example 1:
Input: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Example 2:
Input: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Note:
The range of the input matrix's height and width is [1,50].
The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least 
one clickable square.
The input board won't be a stage when game is over (some mines have been revealed).
For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the 
unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Minesweeper {
    private final static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
            { -1, -1 } };

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length < 1 || click == null || click.length != 2) {
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (board[pos[0]][pos[1]] == 'M') {
                board[pos[0]][pos[1]] = 'X';
                break;
            }

            if (board[pos[0]][pos[1]] == 'E') {
                int count = 0;
                for (int[] dir : dirs) {
                    int ni = pos[0] + dir[0];
                    int nj = pos[1] + dir[1];
                    if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length) {
                        continue;
                    }
                    if (board[ni][nj] == 'M') {
                        count++;
                    }
                }
                if (count > 0) {
                    board[pos[0]][pos[1]] = (char) ('0' + count);
                } else {
                    board[pos[0]][pos[1]] = 'B';
                    for (int[] dir : dirs) {
                        int ni = pos[0] + dir[0];
                        int nj = pos[1] + dir[1];
                        if (ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length || board[ni][nj] != 'E') {
                            continue;
                        }
                        if (!visited.contains(ni * board[0].length + nj)) {
                            queue.add(new int[]{ni, nj});
                            visited.add(ni * board[0].length + nj);
                        }
                    }
                }
            }
        }

        return board;
    }
}
