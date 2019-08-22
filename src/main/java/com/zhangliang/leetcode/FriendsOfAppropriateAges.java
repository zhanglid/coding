package com.zhangliang.leetcode;
/*
Some people will make friend requests. The list of their ages is given and ages[i] is the age of 
the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request 
themselves.

How many total friend requests are made?

Example 1:
Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.

Example 2:
Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.

Example 3:
Input: [20,30,100,110,120]
Output: 
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.

Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.
*/

import java.util.*;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int ans = 0;
        int[] counts = new int[120];
        for (int age : ages) {
            counts[age - 1]++;
        }
        for (int age : ages) {
            for (int i = 1; i <= 120; i++) {
                if (i > age) {
                    continue;
                } else if (i <= age / 2 + 7) {
                    continue;
                }
                ans += counts[i - 1];
                if (i == age) {
                    ans--;
                }
            }
        }
        return ans;
    }
}
