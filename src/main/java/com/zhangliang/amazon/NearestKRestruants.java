package com.zhangliang.amazon;
/*
Top K closest numbers / 找最近的K个餐馆 / 饭店最近的位置 / 给一堆的餐馆的位置，和customer的位置，找出离customer 
最近的餐馆。 / 找最近的k个餐馆，给了餐馆的坐标，和距离的定义 / 一个是求K个最近的餐馆，用heap做就好了。
Given a list of points, and a point, find the K closest points

*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NearestKRestruants {
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public List<Integer> nearestKRestruants(int[][] points, int K) {
        List<Integer> ans = new ArrayList<>();
        if (points == null || points.length < 1) {
            return ans;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return dist(points[a]) - dist(points[b]);
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.add(i);
        }

        while (!pq.isEmpty() && ans.size() < K) {
            ans.add(pq.poll());
        }

        return ans;
    }
}
