package com.zhangliang.google;
/*
maximum weight bipartite matching?
匈牙利算法？
最大权匹
南亚老头子，就说有一堆玩具，分属于不同的category，
并且有红蓝两种颜色，问一种算法让其中玩具两两配对，

配对规则 
1.category和颜色都最好不一样，并且使这样的对数最大化，
2.如果无法满足category或者颜色不一样，那么去掉其中的一个条件，
让这样的配对数最大化，
3.如果1,2条件都不能满足，那么就都一样的也要配对，
输入是一个array，array里面的元素是个tuple (ID，color, category)，输出是配好的pair.

(1, CAT1, C1)
(2, CAT2, C2)
(3, CAT3, C1)

这轮体验不太好，首先题目比较复杂，而且面试官口音很严重，
比如pair 他一直在说peer，我是真没搞清楚他让我干啥，
然后我说能不能给我一个例子，他也没理我，就一只重复peer，peer，
大概花了十五分钟左右才明白了题意。另外题目也说的不是很清楚，
这个开始就是说输出category和颜色都不一样的pair，
我单纯的认为输出category和颜色都不一样的pair就好了，
结果我都要写完了，他就又说要是无法同时满足这两个条件，可以去掉一个条件再配对。还有一个很要命的是这个面试官似乎对python不是很熟悉，我已经在边写边解释给他听了，但是他还是要总叫我停下来，然后他真的毫不夸张的一个word一个word的读我的代码，实在是太托时间了，我的解法也就是暴力解，这样的情况下，我没有写完， 不知道有没有大神有更好的解法？
*/

import java.util.*;

public class ToyMatching {

  interface Matcher {
    public boolean canMatch(int[] toy1, int[] toy2);
  }

  private boolean dfs(int id, Map<Integer, Integer> matching, Set<Integer> checked, Map<Integer, Set<Integer>> graph) {
    for (Integer other : graph.get(id)) {
      if (checked.contains(other)) {
        continue;
      }
      checked.add(other);
      if (!matching.containsKey(other) || dfs(matching.get(other), matching, checked, graph)) {
        matching.put(id, other);
        matching.put(other, id);
        return true;
      }
    }
    return false;
  }

  private Map<Integer, Set<Integer>> createGraph(List<int[]> toys, Matcher matcher) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] toy : toys) {
      for (int[] other : toys) {
        if (toy == other || !matcher.canMatch(toy, other)) {
          continue;
        }
        int a = toy[0];
        int b = other[0];
        if (!graph.containsKey(a)) {
          graph.put(a, new HashSet<>());
        }
        if (!graph.containsKey(b)) {
          graph.put(b, new HashSet<>());
        }
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
    }

    return graph;
  }

  Matcher[] matchers = new Matcher[] { new Matcher() {
    public boolean canMatch(int[] toy1, int[] toy2) {
      return toy1[1] != toy2[1] && toy1[2] != toy2[2];
    }
  }, new Matcher() {
    public boolean canMatch(int[] toy1, int[] toy2) {
      return toy1[1] != toy2[1] || toy1[2] != toy2[2];
    }
  }, new Matcher() {
    public boolean canMatch(int[] toy1, int[] toy2) {
      return true;
    }
  } };

  // [id, cat, color]
  public Map<Integer, Integer> solve(int[][] input) {
    List<int[]> toys = Arrays.asList(input);
    Map<Integer, Integer> matching = new HashMap<>();
    for (Matcher matcher : matchers) {
      Map<Integer, Set<Integer>> graph = createGraph(toys, matcher);
      for (Integer node : graph.keySet()) {
        dfs(node, matching, new HashSet<>(), graph);
      }
      List<int[]> next = new ArrayList<>();
      for (int[] toy : toys) {
        if (!matching.containsKey(toy[0])) {
          next.add(toy);
        }
      }
      toys = next;
    }

    return matching;
  }
}
