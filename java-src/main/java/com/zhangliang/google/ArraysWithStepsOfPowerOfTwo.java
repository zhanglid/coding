package com.zhangliang.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给一个integer N, 求所有以0开始，以N结尾，以2的次方增长的数列。 
    例如 N = 3: 
        [0, 1, 2, 3] 
        [0, 1, 3] 
        [0, 2, 3]
*/

public class ArraysWithStepsOfPowerOfTwo {
    public List<List<Integer>> listArrays(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<List<List<Integer>>> dp = new ArrayList<>();

        dp.add(Arrays.asList(Arrays.asList(0)));

        for (int i = 1; i <= n; i++) {
            dp.add(new ArrayList<>());
            for (int step = 1; step <= i; step = step * 2) {
                List<List<Integer>> prevLists = dp.get(i - step);
                for (List<Integer> list : prevLists) {
                    List<Integer> cur = new ArrayList<>(list);
                    cur.add(i);
                    dp.get(i).add(cur);
                }
            }
        }

        return dp.get(n);
    }
}