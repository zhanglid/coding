package com.zhangliang.leetcode;
/*
We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. 
For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in 
the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by 
buses only, what is the least number of buses we must take to reach our destination? Return -1 
if it is not possible.

Example:
Input: 
routes = [
    [1, 2, 7], 
    [3, 6, 7]
]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus 
stop 6.
Note:
1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.

*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length < 1) {
            return 0;
        }

        Map<Integer, Set<int[]>> graph = new HashMap<>();

        for (int[] route : routes) {
            for (int point : route) {
                if (!graph.containsKey(point)) {
                    graph.put(point, new HashSet<>());
                }
                graph.get(point).add(route);
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(S);
        queue.add(S);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int point = queue.poll();
                if (point == T) {
                    return count;
                }
                for (int[] others : graph.get(point)) {
                    for (int other : others) {
                        if (!visited.contains(other)) {
                            queue.add(other);
                            visited.add(other);
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
