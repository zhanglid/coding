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
Your algorithm's time complexity must be better than O(n log n), 
where n is the array's size.
*/

import java.util.*;

public class TopKFrequentElements {
    private Map<Integer, Integer> generateFrequencyMap(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return freqMap;
    }

    private List<Integer> findTopKFromFreqMap(Map<Integer, Integer> freqMap, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return freqMap.get(a) - freqMap.get(b);
            }
        });

        for (int key : freqMap.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(pq);
        Collections.reverse(ans);
        return ans;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        return findTopKFromFreqMap(generateFrequencyMap(nums), k);
    }
}
