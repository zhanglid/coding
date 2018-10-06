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

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T)  {
        if (routes == null || routes.length < 1) {
            return 0;
        }

        Map<Integer, List<Integer>> buses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                buses.putIfAbsent(stop, new ArrayList<>());
                buses.get(stop).add(i);
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.add(S);
        int step = 0;
        Set<Integer> vistedBuses = new HashSet<>();
        Set<Integer> visitedStop = new HashSet<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer stop = queue.poll();
                if (stop == T) {
                    return step;
                }
                for (int bus : buses.get(stop)) {
                    if (!vistedBuses.contains(bus)) {
                        vistedBuses.add(bus);
                        for (int  nextStop : routes[bus]) {
                            if (!visitedStop.contains(nextStop)) {
                                queue.add(nextStop);
                                visitedStop.add(nextStop);
                            }
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
