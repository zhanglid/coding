package com.zhangliang.leetcode;
/*
Equations are given in the format A / B = k, where A and B are variables represented as strings, 
and k is a real number (floating point number). Given some queries, return the answers. 
If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , 
where equations.size() == values.size(), and the values are positive. This represents the equations. 
Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and 
there is no contradiction.
*/

import java.util.*;

public class EvaluateDivision {
    private Map<String, Map<String, Double>> getGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String to = equation.get(1);
            if (!graph.containsKey(from)) {
                graph.put(from, new HashMap<>());
            }
            if (!graph.containsKey(to)) {
                graph.put(to, new HashMap<>());
            }
            graph.get(from).put(to, values[i]);
            if (values[i] != 0) {
                graph.get(to).put(from, 1 / values[i]);
            }
        }
        return graph;
    }

    private Double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (!graph.containsKey(from)) {
            return null;
        }
        if (from.equals(to)) {
            return 1.0;
        }
        visited.add(from);
        for (String other : graph.get(from).keySet()) {
            if (visited.contains(other)) {
                continue;
            }
            Double otherVal = dfs(graph, other, to, visited);
            if (otherVal != null) {
                return otherVal * graph.get(from).get(other);
            }
        }
        visited.remove(from);
        return null;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = getGraph(equations, values);
        double[] result = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            Double value = dfs(graph, query.get(0), query.get(1), new HashSet<>());
            result[i++] = value == null ? -1 : value;
        }
        return result;
    }
}
