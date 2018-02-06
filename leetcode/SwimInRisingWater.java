/*
On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:

Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:

Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
Note:

2 <= N <= 50.
grid[i][j] is a permutation of [0, ..., N*N - 1].




*/

/*
*  Solution: 每次取最低点进行BFS扩展，记录边界。
*
*  Corner Case: [[3,2],[0,1]] => 3, 1!: 初始化的点[0][0]未必是最低点。此时如果
*               t赋值为1, 会默认[0][0]位置的3已经满足，从而产生错误！
*
*  Complexity: N is the number of points in the grid. o(N)
*/
import java.util.*;

class SwimInRisingWater {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int target = m * n - 1;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        pq.offer(new int[2]);
        set.add(0);
        int t = Math.max(grid[0][0], grid[m - 1][n - 1]);
        // int t = 0;
        while (!set.contains(target)) {
            int[] pair = pq.poll();
            t = Math.max(t, pair[1]);
            
                
            //expand(set, pair[0] / n, pair[0] % m, grid, pq);
            int i = pair[0] / n;
            int j = pair[0] % m;
            set.add(i * n + j);
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n || set.contains(ni * n + nj)) {
                    continue;
                }
                int[] newPair = new int[2];
                newPair[0] = ni * n + nj;
                newPair[1] = grid[ni][nj];
                pq.offer(newPair);
            }
        }
        
        return t;
    }

    public static void main(String[] args) {
        SwimInRisingWater s = new SwimInRisingWater();
        System.out.println(s.swimInWater(new int[][]{{3, 2}, {0, 1}}));
    }
}