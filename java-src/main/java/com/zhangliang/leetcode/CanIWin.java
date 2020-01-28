package com.zhangliang.leetcode;

/*
In the "100 game," two players take turns adding, to a running total, 
any integer from 1..10. The player who first causes the running total 
to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of 
numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, 
determine if the first player to move can force a win, assuming both 
players play optimally.

You can always assume that maxChoosableInteger will not be larger than 
20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will 
lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers 
from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which 
is >= desiredTotal.
Same with other integers chosen by the first player, the second player 
will always win.
*/

import java.util.*;

public class CanIWin {
    private void dfs(int[] dp, int status, int chs, int target) {
        if (dp[status] != 0) {
            return;
        }
        if (chs >= target) {
            dp[status] = -1;
            return;
        }
        int value = 1;
        int mask = 1;
        while ((status & ~(mask - 1)) != 0) {
            if ((status & mask) != 0) {
                dfs(dp, status ^ mask, chs + value, target);
                if (dp[status ^ mask] == -1) {
                    dp[status] = 1;
                    return;
                }
            }

            mask = mask << 1;
            value++;
        }
        dp[status] = -1;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        int size = 1 << maxChoosableInteger;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        int[] dp = new int[size];
        if (sum < desiredTotal) {
            return false;
        }
        dfs(dp, size - 1, 0, desiredTotal);
        return dp[size - 1] == 1;
    }
}
