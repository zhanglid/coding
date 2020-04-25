package com.zhangliang.leetcode;
/*
There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it. 
The costs to lay pipes between houses are given by the array pipes, where each pipes[i] = [house1, house2, cost] represents 
the cost to connect house1 and house2 together using a pipe. Connections are bidirectional.

Find the minimum total cost to supply water to all houses.

Example 1:

Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: 
The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
 

Constraints:

1 <= n <= 10000
wells.length == n
0 <= wells[i] <= 10^5
1 <= pipes.length <= 10000
1 <= pipes[i][0], pipes[i][1] <= n
0 <= pipes[i][2] <= 10^5
pipes[i][0] != pipes[i][1]
*/

import java.util.*;

public class OptimizeWaterDistributionInAVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        // Connect source to each house, as we can think well as a source connected to
        // each house.
        costs.put(0, new HashMap<>());
        for (int i = 0; i < wells.length; i++) {
            costs.get(0).put(i + 1, wells[i]);
        }
        for (int[] pipe : pipes) {
            if (!costs.containsKey(pipe[0])) {
                costs.put(pipe[0], new HashMap<>());
            }
            if (!costs.containsKey(pipe[1])) {
                costs.put(pipe[1], new HashMap<>());
            }
            int value = pipe[2];
            if (costs.get(pipe[0]).containsKey(pipe[1])) {
                value = Math.min(value, costs.get(pipe[0]).get(pipe[1]));
            }
            costs.get(pipe[0]).put(pipe[1], value);
            costs.get(pipe[1]).put(pipe[0], value);
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        pq.add(new int[] { 0, 0 });
        int cost = 0;
        while (visited.size() != n + 1) {
            int[] pair = pq.poll();
            if (visited.contains(pair[0])) {
                continue;
            }
            cost += pair[1];
            visited.add(pair[0]);
            if (costs.containsKey(pair[0])) {
                for (int i : costs.get(pair[0]).keySet()) {
                    if (!visited.contains(i)) {
                        pq.add(new int[] { i, costs.get(pair[0]).get(i) });
                    }
                }
            }
        }
        return cost;
    }
}
