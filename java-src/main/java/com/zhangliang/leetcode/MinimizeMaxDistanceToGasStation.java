package com.zhangliang.leetcode;
/*
On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where 
N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.
*/

import java.util.*;

public class MinimizeMaxDistanceToGasStation {
    private boolean check(int[] stations, int K, double dist) {
        for (int i = 0; i < stations.length - 1; i++) {
            int curDist = stations[i + 1] - stations[i];
            int num = (int) Math.ceil((double) curDist / dist) - 1;
            K -= num;
            if (K < 0) {
                return false;
            }
        }
        return true;
    }

    public double minmaxGasDist(int[] stations, int K) {
        double max = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            max = Math.max(stations[i + 1] - stations[i], max);
        }
        double min = 0;

        while (max - min >= 0.000001) {
            double mid = min + (max - min) / 2;
            if (check(stations, K, mid)) {
                max = mid;
            } else {
                min = mid;
            }
        }

        return min;
    }
}
