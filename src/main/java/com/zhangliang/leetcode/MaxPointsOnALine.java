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
        int delta = a[0] - b[0];
        int alpha = a[1] - b[1];
        if (delta == 0) {
            return Integer.toString(a[0]);
        }
        int gcd = GCD(delta, alpha);
        delta /= gcd;
        alpha /= gcd;
        return Integer.toString(delta) + "," + Integer.toString(alpha) + ","
                + Double.toString(a[1] - a[0] * alpha / delta);
    }

    public int maxPoints(int[][] points) {
        Map<String, Set<Integer>> pointIndexesByLine = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                String hashCode = hash(points[i], points[j]);
                if (!pointIndexesByLine.containsKey(hashCode)) {
                    pointIndexesByLine.put(hashCode, new HashSet<>());
                }
                pointIndexesByLine.get(hashCode).add(i);
                pointIndexesByLine.get(hashCode).add(j);
            }
        }

        int ans = points.length < 1 ? 0 : 1;
        for (Set<Integer> indexSet : pointIndexesByLine.values()) {
            ans = Math.max(ans, indexSet.size());
        }
        return ans;
    }
}
