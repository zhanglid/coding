package com.zhangliang.leetcode;
/*
Given a set of points in the xy-plane, determine the 
minimum area of a rectangle formed from these points, 
with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.

Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4

Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2
 

Note:

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
*/

import java.util.*;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                if (map.get(a[0]).contains(b[1]) && map.get(b[0]).contains(a[1])) {
                    int area = Math.abs(a[1] - b[1]) * Math.abs(a[0] - b[0]);
                    if ((result == 0 || area < result) && area != 0) {
                        result = area;
                    }
                }
            }
        }
        return result;
    }
}
