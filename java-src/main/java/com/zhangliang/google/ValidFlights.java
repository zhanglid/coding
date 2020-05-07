package com.zhangliang.google;
/*
 给一个 string[]， 比如 ["LAX", "SFO", "SEZ"] 代表洛杉矶飞三番再飞西雅图，
 但是西雅图机场code 应该是SEA, 所以input需要改动一个字符来变成合法的路线。
 给出一些helper methods 比如  List<String> getNeighbors("LAX") 
 返回洛杉矶出发可以到达的机场..
 写一个method   String[] validPath(String[] path)   
 返回一个合法的最少改动的合法路线即可，比如返回  ["LAX", "SFO", "DEH"]也可以。
 我一下没想出好的解先暴力DFS写了，面试官提示可否优化比如BFS... 反正被他一路提示，最后用Priorityqueue优化
*/

import java.util.*;

public class ValidFlights {
  class State {
    String site;
    int index;
    int cost;
    List<String> path;

    public State(String site) {
      this.path = new ArrayList<>();
      this.site = site;
      this.cost = 0;
      this.index = 0;
    }
  }

  public String[] validPath(String[] input, Map<String, Set<String>> graph) {
    if (input.length < 1) {
      return input;
    }
    PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
      public int compare(State s1, State s2) {
        int diff = s1.cost - s2.cost;
        return diff == 0 ? s2.index - s1.index : diff;
      }
    });

    pq.add(new State(null));
    while (!pq.isEmpty()) {
      State s = pq.poll();
      if (s.index == input.length) {
        return s.path.toArray(new String[0]);
      }
      for (String next : graph.keySet()) {
        State ns = new State(next);
        ns.index = s.index + 1;
        ns.cost = s.cost;
        ns.path = new ArrayList<>(s.path);
        ns.path.add(next);
        if (s.site == null || !graph.get(s.site).contains(next)) {
          ns.cost++;
        }
        pq.add(ns);
      }
    }

    return null;
  }
}
