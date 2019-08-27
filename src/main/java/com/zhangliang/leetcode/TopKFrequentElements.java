package com.zhangliang.leetcode;
/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

import java.util.*;

public class TopKFrequentElements {
    private Map<Integer, Integer> getCounts(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return counts;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = getCounts(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        for (Integer key : counts.keySet()) {
            pq.add(new int[] { key, counts.get(key) });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }
        return ans;
    }
}
