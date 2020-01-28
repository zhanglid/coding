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

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org == null || seqs == null || org.length < 1 || seqs.size() < 1) {
            return false;
        }

        Map<Integer, Set<Integer>> outMap = new HashMap<>();
        Map<Integer, Set<Integer>> inMap = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (!outMap.containsKey(seq.get(i))) {
                    outMap.put(seq.get(i), new HashSet<>());
                    inMap.put(seq.get(i), new HashSet<>());
                }
                if (i >= 1) {
                    outMap.get(seq.get(i - 1)).add(seq.get(i));
                    inMap.get(seq.get(i)).add(seq.get(i - 1));
                }
            }
        }

        if (outMap.size() != org.length) {
            return false;
        }

        Deque<Integer> stack = new LinkedList<>();

        for (int x : inMap.keySet()) {
            if (inMap.get(x).size() == 0) {
                stack.push(x);
            }
        }

        if (stack.isEmpty()) {
            return false;
        }
        int index = 0;
        while (!stack.isEmpty()) {
            if (stack.size() > 1) {
                return false;
            }

            int x = stack.pop();
            if (x != org[index++]) {
                return false;
            }

            for (int y : outMap.get(x)) {
                inMap.get(y).remove(x);
                if (inMap.get(y).size() == 0) {
                    stack.push(y);
                }
            }
        }

        return index == org.length;
    }
}
