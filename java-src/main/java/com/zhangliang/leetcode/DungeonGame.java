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

        int[][] dp = new int[dungeon.length][dungeon[0].length];

        dp[dungeon.length - 1][dungeon[0].length - 1] = 1
                - Math.min(0, dungeon[dungeon.length - 1][dungeon[0].length - 1]);

        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                int target = dp[i][j];
                if (j > 0) {
                    int cur = Math.max(1, target - dungeon[i][j - 1]);
                    dp[i][j - 1] = dp[i][j - 1] == 0 ? cur : Math.min(cur, dp[i][j - 1]);
                }
                if (i > 0) {
                    int cur = Math.max(1, target - dungeon[i - 1][j]);
                    dp[i - 1][j] = dp[i - 1][j] == 0 ? cur : Math.min(cur, dp[i - 1][j]);
                }
            }
        }

        return dp[0][0];
    }
}
