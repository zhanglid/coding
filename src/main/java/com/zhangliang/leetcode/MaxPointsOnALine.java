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
import java.util.Map;

import com.zhangliang.utils.Point;

public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points == null || points.length < 1) {
            return 0;
        }

        int ans = 0;
        for (Point point : points) {
            Map<String, Integer> countMap = new HashMap<>();
            int duplicate = -1;
            for (Point point2 : points) {
                if (point.x == point2.x && point.y == point2.y) {
                    duplicate++;
                    ans = Math.max(ans, duplicate);
                    continue;
                }

                int[] diff = new int[] { point.x - point2.x, point.y - point2.y };
                int g = gcd(diff[0], diff[1]);
                diff[0] /= g;
                diff[1] /= g;

                String key = diff[0] + "," + diff[1];
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            }

            for (int num : countMap.values()) {
                ans = Math.max(ans, num + duplicate);
            }
        }

        return ans + 1;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return x % y == 0 ? y : gcd(y, x % y);
    }
}
