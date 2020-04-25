package com.zhangliang.amazon;
/*
一个小哥去爬山，给一个矩阵，要从左上角爬到右下角，每一步只能往右往下走。矩阵的每一个值是这一点的海拔。显然有很多条路可以走，
每一条路都有一个经过的海拔最低值，求所有路径的海拔最低值的最大值。
比如：
5 4 5
1 3 6
有三条路可以走：5 1 3 6，5 4 3 6，5 4 5 6。三条路的最小值分别是1,3,4。求的就是这三个数的最大值，也就是4
*/

public class HighestLowestPointPath {
    static public int solve(int[][] map) {
        if (map == null || map.length < 1 || map[0].length < 1) {
            return 0;
        }
        int[][] dp = new int[map.length][map[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = map[i][j];
                if (i - 1 >= 0 || j - 1 >= 0) {
                    int source = Math.max(i - 1 >= 0 ? dp[i - 1][j] : Integer.MIN_VALUE,
                            j - 1 >= 0 ? dp[i][j - 1] : Integer.MIN_VALUE);
                    dp[i][j] = Math.min(dp[i][j], source);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
