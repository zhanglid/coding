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
*/ import java.util.*;

public class CanIWin {
    // Number chosen status set is limited, so we can use dp to optimize it.
    private Map<Integer, Boolean> cache = new HashMap<>();

    private boolean helper(int status, int sum, int desiredTotal) {
        if (cache.containsKey(status)) {
            return cache.get(status);
        }
        if (sum >= desiredTotal) {
            cache.put(status, false);
            return false;
        }
        int base = 1;
        int num = 1;
        while (base <= status) {
            if ((status & base) != 0) {
                status -= base;
                boolean willWin = helper(status, sum + num, desiredTotal);
                status += base;
                if (!willWin) {
                    cache.put(status, true);
                    return true;
                }
            }
            base *= 2;
            num++;
        }
        cache.put(status, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        // Attention: If desiredTotal is too larger, neither player will win.
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        int status = 0;
        int base = 1;
        for (int i = 0; i < maxChoosableInteger; i++) {
            status += base;
            base *= 2;
        }
        return helper(status, 0, desiredTotal);
    }
}
