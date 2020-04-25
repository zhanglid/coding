package com.zhangliang.leetcode;
/*
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of 
unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:

Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must 
have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.
 


Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:

Input: m = 1, n = 1
Output: 9
*/

import java.util.LinkedList;
import java.util.Queue;

public class AndroidUnlockPatterns {
    class State {
        public boolean[] status = new boolean[9];
        public int pos = 0;

        public State(State state) {
            for (int i = 0; i < status.length; i++) {
                status[i] = state.status[i];
            }
            pos = state.pos;
        }

        public State() {
        }
    }

    private int getMiddle(int a, int b) {
        int ai = a / 3;
        int bi = b / 3;
        int aj = a % 3;
        int bj = b % 3;

        if (ai != bi && aj != bj && (Math.abs(ai - bi) != 2 || Math.abs(aj - bj) != 2)) {
            return a;
        }

        return 3 * ((ai + bi) / 2) + (aj + bj) / 2;
    }

    public int numberOfPatterns(int m, int n) {
        n = Math.min(9, n);
        if (m < 0 || m > n || m > 9) {
            return 0;
        }
        int ans = 0;
        Queue<State> queue = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            State state = new State();
            state.pos = i;
            state.status[i] = true;
            queue.add(state);
        }
        int size = 1;
        while (size < n && !queue.isEmpty()) {
            int queueSize = queue.size();
            if (size >= m && size <= n) {
                ans += queueSize;
            }
            for (int i = 0; i < queueSize; i++) {
                State cur = queue.poll();
                for (int j = 0; j < 9; j++) {
                    int mid = getMiddle(cur.pos, j);
                    if ((mid == cur.pos || mid == j || cur.status[mid]) && !cur.status[j]) {
                        State next = new State(cur);
                        next.status[j] = true;
                        next.pos = j;
                        queue.add(next);
                    }
                }
            }
            size++;
        }
        if (size <= n) {
            ans += queue.size();
        }
        return ans;
    }
}
