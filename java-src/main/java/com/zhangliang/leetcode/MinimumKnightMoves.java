package com.zhangliang.leetcode;
/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, 
then one square in an orthogonal direction.

Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]

Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 

Constraints:

|x| + |y| <= 300
*/

import java.util.*;

public class MinimumKnightMoves {
    private static final int[][] DIRS = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -1, 2 },
            { -2, 1 } };

    private int getHash(int x, int y) {
        return (x + 300) + (y + 300) * 1000;
    }

    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int[] target = new int[] { x, y };
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int distDiff = getDist(a, target) - getDist(b, target);
                int countDiff = a[2] - b[2];
                return countDiff == 0 ? distDiff : countDiff;
            }
        });
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[] { 0, 0, 0 });
        visited.add(getHash(0, 0));
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            // System.out.println(Arrays.toString(point));
            if (point[0] == x && point[1] == y) {
                return point[2];
            }
            for (int[] dir : DIRS) {
                int ni = point[0] + dir[0];
                int nj = point[1] + dir[1];
                int count = point[2] + 1;
                int hash = getHash(ni, nj);
                if (visited.contains(hash) || ni < -1 || nj < -1) {
                    continue;
                }
                visited.add(hash);
                pq.add(new int[] { ni, nj, count });
            }
        }
        return -1;
    }
}
