package com.zhangliang.leetcode;
/*
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org 
sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a 
shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in 
seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from 
seqs and it is the org sequence.

Example 1:

Input:
org: [1,2,3], seqs: [[1,2],[1,3]]

Output:
false

Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence 
that can be reconstructed.
Example 2:

Input:
org: [1,2,3], seqs: [[1,2]]

Output:
false

Explanation:
The reconstructed sequence can only be [1,2].
Example 3:

Input:
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

Output:
true

Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input:
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

Output:
true
UPDATE (2017/1/8):
The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings). 
Please reload the code definition to get the latest changes.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org == null || org.length < 1 || seqs == null || seqs.size() < 1) {
            return false;
        }

        if (org.length == 1) {
            return true;
        }

        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        Map<Integer, Set<Integer>> indegree = new HashMap<>();

        for (int x : org) {
            neighbors.put(x, new HashSet<>());
            indegree.put(x, new HashSet<>());
        }

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                if (!neighbors.containsKey(seq.get(i)) || !neighbors.containsKey(seq.get(i + 1))) {
                    return false;
                }
                neighbors.get(seq.get(i)).add(seq.get(i + 1));
                indegree.get(seq.get(i + 1)).add(seq.get(i));
            }
        }

        int zeroIndegreeNum = 0;
        Map<Integer, Integer> indegreeCounter = new HashMap<>();
        for (Integer key : indegree.keySet()) {
            Set<Integer> num = indegree.get(key);
            if (num.size() == 0) {
                zeroIndegreeNum++;
            }
            indegreeCounter.put(key, num.size());
        }

        if (zeroIndegreeNum > 1) {
            return false;
        }

        for (int x : org) {
            if (!neighbors.containsKey(x)) {
                return false;
            }
            if (indegree.get(x).size() > 0) {
                return false;
            }
            int nextNum = 0;
            for (int other : neighbors.get(x)) {
                indegree.get(other).remove(x);
                indegreeCounter.put(other, indegree.get(other).size());
                if (indegree.get(other).size() == 0) {
                    nextNum++;
                }
            }

            if (nextNum > 1) {
                return false;
            }
        }

        return true;
    }
}
