package com.zhangliang.leetcode;
/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

*/

import java.util.*;

public class MaxPointsOnALine {
    private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    private String hash(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return Integer.toString(a[0]);
        }
        int alpha = a[1] - b[1];
        int delta = a[0] - b[0];
        if (alpha == delta && alpha == 0) {
            return a[0] + "#" + a[1];
        }
        int gcd = GCD(alpha, delta);
        alpha /= gcd;
        delta /= gcd;
        int beta = a[1] * delta - a[0] * alpha;
        return alpha + "," + beta + "," + delta;
    }

    public int maxPoints(int[][] points) {
        Map<String, Set<Integer>> counts = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                String hashCode = hash(points[i], points[j]);
                if (!counts.containsKey(hashCode)) {
                    counts.put(hashCode, new HashSet<>());
                }
                counts.get(hashCode).add(i);
                counts.get(hashCode).add(j);
            }
        }
        int max = Math.max(0, Math.min(1, points.length));
        for (Set<Integer> group : counts.values()) {
            max = Math.max(max, group.size());
        }
        return max;
    }
}
