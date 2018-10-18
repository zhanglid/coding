package com.zhangliang.google;
/*
给一个二维坐标平面和一个起始点，从这点开始垂直下跳，下面有若干水平挡板，位置长度会在 input里给，板的形式是(x, y, distance)，
当跳到挡板上时，可以选择走到挡板的左端或者右端， 然后继续垂直下跳，直到落地位置，求从开始到落地需要走过的路程最短是多少。
对所有板按照 y 轴从上往下排序，然后给每个板两个编号，id[i][0] 和 id[i][1] 分别表示第 i 个板的 左右端点
如果从 id[i][0] 下落能到板 j，那么可以连接两条边 id[i][0] -> id[j][0] 和 id[i][0] -> id[j][1]，权重的话 就是下落之
后左右走的距离 这样就能构造一个有向图，最后求个最短路1
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    // assume index -1 is the floor
public class manJumpProblem {
    Map<Integer, List<Integer>> cache = new HashMap<>();

    public List<Integer> solve(int startIndex, int[][] boards, Map<Integer, List<Integer>> graph) {
        List<Integer> path = new ArrayList<>();
        if (boards == null || graph == null) {
            return path;
        }
        return dfs(startIndex, boards, graph);
    }

    private List<Integer> dfs(int boardIndex, int[][] boards, Map<Integer, List<Integer>> graph) {
        if (boardIndex == -1) {
            return new ArrayList<>();
        }
        if (cache.containsKey(boardIndex)) {
            return cache.get(boardIndex);
        }
        List<Integer> path = null;
        for (int index : graph.get(boardIndex)) {
            List<Integer> choice = dfs(index, boards, graph);
            if (path == null || choice.size() < path.size()) {
                path = choice;
            }
        }
        cache.put(boardIndex, path);
        return path;
    }
}
