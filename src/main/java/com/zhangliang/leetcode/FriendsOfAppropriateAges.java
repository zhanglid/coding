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

import java.util.Arrays;

public class FriendsOfAppropriateAges {
    // return the range that will be requested as friend for age.

    private int[] getRange(int age) {
        return new int[] { age / 2 + 7 + 1, age };
    }

    private int search(int[] ages, int age, boolean isStart) {
        int l = 0;
        int r = ages.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (ages[mid] < age || ages[mid] == age && !isStart) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (isStart) {
            if (ages[l] >= age) {
                return l;
            } else {
                return r;
            }
        } else {
            if (ages[r] <= age) {
                return r;
            } else {
                return l;
            }
        }
    }

    public int numFriendRequests(int[] ages) {
        int ans = 0;
        Arrays.sort(ages);
        for (int age : ages) {
            int[] range = getRange(age);
            if (range[0] > range[1]) {
                continue;
            }
            int start = search(ages, range[0], true);
            int end = search(ages, range[1], false);
            ans += end - start;
        }
        return ans;
    }
}
