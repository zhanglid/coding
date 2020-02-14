package com.zhangliang.leetcode;
/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = 
(u, v, w), where u is the source node, v is the target node, and w is 
the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for 
all nodes to receive the signal? If it is impossible, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2

Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
*/

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        pq.add(new int[] { K - 1, 0 });
        boolean[] visited = new boolean[N];
        int count = 0;
        while (!pq.isEmpty() && count != N) {
            int[] node = pq.poll();
            if (visited[node[0]]) {
                continue;
            }
            count++;
            visited[node[0]] = true;
            graph[K - 1][node[0]] = node[1];
            for (int i = 0; i < N; i++) {
                if (!visited[i] && i != node[0] && graph[node[0]][i] >= 0
                        && (graph[K - 1][i] == -1 || (node[1] + graph[node[0]][i]) <= graph[K - 1][i])) {
                    pq.add(new int[] { i, node[1] + graph[node[0]][i] });
                }
            }
        }
        int maxValue = -1;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, graph[K - 1][i]);
        }
        return count == N ? maxValue : -1;
    }
}
