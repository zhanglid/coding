package com.zhangliang.leetcode;
/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, 
the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical 
order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order 
than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:

Input: [["JFK","SFO"],["JFK","ATL"1],["SFO","ATL"1],["ATL","JFK"1],["ATL","SFO"1]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/

import java.util.*;

/**
 * Assumption: start at JFK, the answer always exists (Always possible to go
 * through all sites)
 * 
 * Approach recursion.
 * 
 */

// JFK -> MUC -> LHR -> SFO -> SJC

public class ReconstructItinerary {
    private void dfs(Map<String, PriorityQueue<String>> graph, String site, Deque<String> result) {
        while (graph.containsKey(site) && !graph.get(site).isEmpty()) {
            String next = graph.get(site).poll();
            dfs(graph, next, result);
        }
        result.addFirst(site);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new PriorityQueue<>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs(graph, "JFK", result);
        return result;
    }
}
