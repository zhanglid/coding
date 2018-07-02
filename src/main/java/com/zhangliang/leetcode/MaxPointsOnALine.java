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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zhangliang.utils.Point;

public class MaxPointsOnALine {
    private void reduce(int[] pair) {
        if (pair[0] == 0 && pair[1] == 0) {
            return;
        }

        if (pair[0] == 0) {
            pair[1] = 1;
            return;
        }

        if (pair[1] == 0) {
            pair[0] = 1;
            return;
        }

        if (pair[0] < 0 && pair[1] < 0) {
            pair[0] = -pair[0];
            pair[1] = -pair[1];
        } else if (pair[0] < 0 && pair[1] > 0 || pair[0] > 0 && pair[1] < 0) {
            pair[0] = Math.abs(pair[0]);
            pair[1] = -Math.abs(pair[1]);
        }

        for (int i = 2; i <= Math.sqrt(pair[1]); i++) {
            if (pair[0] % i == 0 && pair[1] % i == 0) {
                pair[0] = pair[0] % i;
                pair[1] = pair[1] % i;
            }
        }

        if (pair[0] == pair[1]) {
            pair[0] = 1;
            pair[1] = 1;
        }

        if (pair[0] == -pair[1]) {
            pair[0] = 1;
            pair[1] = -1;
        }
    }

    private String getKey(int[] pair) {
        return pair[0] + "," + pair[1];
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length < 1) {
            return 0;
        }

        Map<String, Set<Point>> counter = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point a = points[i];
                Point b = points[j];
                int[] diff = new int[] { a.x - b.x, a.y - b.y };
                reduce(diff);
                String key = getKey(diff);
                if (!counter.containsKey(key)) {
                    counter.put(key, new HashSet<>());
                }
                counter.get(key).add(points[i]);
                counter.get(key).add(points[j]);
            }
        }

        int ans = 1;
        for (Set<Point> set : counter.values()) {
            ans = Math.max(ans, set.size());
        }

        return ans;
    }
}
