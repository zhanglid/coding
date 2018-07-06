package com.zhangliang.leetcode;
/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned 
in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point 
drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these 
rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in 
each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal 
path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)
 

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where 
the princess is imprisoned.
*/

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length < 1 || dungeon[0].length < 1) {
            return 0;
        }

        int[][] curDP = new int[dungeon.length][dungeon[0].length];
        int[][] minDP = new int[dungeon.length][dungeon[0].length];
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                if (i == 0 && j == 0) {
                    curDP[0][0] = dungeon[0][0];
                    minDP[0][0] = dungeon[0][0];
                    continue;
                }

                if (j > 0 && (i == 0 || minDP[i - 1][j] < minDP[i][j - 1])) {
                    // select left
                    curDP[i][j] = curDP[i][j - 1] + dungeon[i][j];
                    minDP[i][j] = Math.min(minDP[i][j - 1], curDP[i][j]);
                } else {
                    // select up
                    curDP[i][j] = curDP[i - 1][j] + dungeon[i][j];
                    minDP[i][j] = Math.min(minDP[i - 1][j], curDP[i][j]);
                }
            }
        }

        return -minDP[dungeon.length - 1][dungeon[0].length - 1] + 1;
    }
}
