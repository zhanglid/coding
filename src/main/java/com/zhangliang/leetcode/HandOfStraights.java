package com.zhangliang.leetcode;
/*
Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.

Note:
1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
*/

import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || W <= 0 || hand.length % W != 0) {
            return false;
        }

        int size = hand.length / W;
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int x : hand) {
            if (map.get(x) <= 0) {
                continue;
            }

            Map<Integer, Integer> counter = new HashMap<>();

            counter.put(x, map.getOrDefault(x, 0));

            int c = x - 1;
            int total = counter.get(x);

            // to left
            while(map.getOrDefault(c, 0) > 0) {
                counter.put(c, map.get(c));
                total += map.get(c);
                map.put(c, 0);
                c--;
            }

            int smallest = c + 1;

            // to right
            c = x + 1;
            while(map.getOrDefault(c, 0) > 0 ) {
                counter.put(c, map.get(c));
                total += map.get(c);
                map.put(c, 0);
                c++;
            }

            if (total % size != 0) {
                return false;
            }

            for (int i = 0; i < total / size; i++) {
                int next = smallest;
                boolean foundNext = false;
                for (int j = 0; j < size; j++) {
                    int num = counter.getOrDefault(smallest + j, 0);
                    if (num < 1) {
                        return false;
                    }

                    if (num - 1 > 0 && ! foundNext) {
                        next = smallest + j;
                        foundNext = true;
                    }

                    counter.put(smallest + j, num - 1);
                }
                smallest = next;
            }

        }

        return true;
    }
}
