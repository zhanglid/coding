package com.zhangliang.leetcode;
/*
You are given two integer arrays nums1 and nums2 sorted in ascending order 
and an integer k.

Define a pair (u,v) which consists of one element from the first array and 
one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1 || k < 1) {
            return ans;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]);
            }
        });
        int i = 0;
        int j = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(i * nums2.length + j);
        pq.add(new int[] { 0, 0 });
        while (!pq.isEmpty() && ans.size() < k) {
            int[] cur = pq.poll();
            ans.add(new int[] { nums1[cur[0]], nums2[cur[1]] });
            if (cur[0] + 1 < nums1.length && !visited.contains((cur[0] + 1) * nums2.length + cur[1])) {
                visited.add((cur[0] + 1) * nums2.length + cur[1]);
                pq.add(new int[] { cur[0] + 1, cur[1] });
            }
            if (cur[1] + 1 < nums2.length && !visited.contains(cur[0] * nums2.length + cur[1] + 1)) {
                visited.add(cur[0] * nums2.length + cur[1] + 1);
                pq.add(new int[] { cur[0], cur[1] + 1 });
            }
        }

        return ans;
    }
}
