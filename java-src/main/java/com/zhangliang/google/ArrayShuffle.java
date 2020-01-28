package com.zhangliang.google;
/*
数组1是排好序的1-n个数字，数组2是根据数组1 shuffle得出，给定数组3，要求根据一样的 shuffle规则变换成
数组4，输出数组4。
第一个follow up，如果数组一是无重复数字组成的无序数组，如何做
第二个follow up，数组1有重复。
假如arr1 = {1, 2, 3, 4}, arr2 = {4, 2, 1, 3}
首先需要预处理arr2，得到val2NewIndex map 然后遍历arr1，新建index2NewIndex，那么index2NewIndex.
put(i, val2NewIndex.get(a[i])) 对于arr3，根据index2NewIndex逐个填写元素到arr4中即可。
Follow-up 1
跟上面做法相同
Follow-up 2
将val2NewIndex map的每个值变成List<Integer>就行了
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayShuffle {
    public int[] solve(int[] arr1, int[] arr2, int[] arr3) {
        int[] ans = new int[arr1.length];
        Map<Integer, Integer> value2Index = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            value2Index.put(arr2[i], i);
        }
        Map<Integer, Integer> index2index = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            index2index.put(i, value2Index.get(arr1[i]));
        }
        for (int i = 0; i < arr3.length; i++) {
            int newIndex = index2index.get(i);
            ans[newIndex] = arr3[i];
        }
        return ans;
    }

    public int[] solveWithDuplicate(int[] arr1, int[] arr2, int[] arr3) {
        int[] ans = new int[arr1.length];
        Map<Integer, List<Integer>> value2Index = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            if (!value2Index.containsKey(arr2[i])) {
                value2Index.put(arr2[i], new ArrayList<>());
            }
            value2Index.get(arr2[i]).add(i);
        }
        Map<Integer, List<Integer>> index2index = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            index2index.put(i, value2Index.get(arr1[i]));
            value2Index.put(arr1[i], new ArrayList<>());
        }
        for (int i = 0; i < arr3.length; i++) {
            for (Integer nextIndex : index2index.get(i)) {
                ans[nextIndex] = arr3[i];
            }
        }
        return ans;
    }
}
