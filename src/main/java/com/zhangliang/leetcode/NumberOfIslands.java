package com.zhangliang.leetcode;
/*\
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water 
and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid 
are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

import java.util.HashMap;
import java.util.Map;

public class NumberOfIslands {
    class UnionFind {
        private Map<Integer, Integer> fathers;

        public UnionFind() {
            fathers = new HashMap<>();
        }

        public int getRoot(int node) {
            if (fathers.get(node) == node) {
                return node;
            }

            int root = getRoot(fathers.get(node));
            fathers.put(node, root);
            return root;
        }

        public boolean connect(int a, int b) {
            int rootA = getRoot(a);
            int rootB = getRoot(b);

            if (rootA == rootB) {
                return false;
            }
            fathers.put(rootA, rootB);
            return true;
        }

        public void addNode(int key) {
            fathers.put(key, key);
        }
    }

    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        UnionFind uf = new UnionFind();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    uf.addNode(i * grid[0].length + j);
                    count++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];

                        if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] != '1') {
                            continue; 
                        }

                        if (uf.connect(ni * grid[0].length + nj, i * grid[0].length + j)) {
                            count--;
                        }
                    }
                }
            }
        }

        return count;
    }
}
