package com.zhangliang.lintcode;
/*
Give you an integer array (index from 0 to n-1, where n is the size of this array, 
data value from 0 to 10000) . For each element Ai in the array, count the number of 
element before this element Ai is smaller than it and return count number array.

Example
For array [1,2,7,8,5], return [0,1,2,3,2]
*/

import java.util.ArrayList;
import java.util.List;

import com.zhangliang.utils.SegmentTreeNode;

public class CountOfSmallerNumberBeforeItself {
    /**
     * @param A:
     *            an integer array
     * @return: A list of integers includes the index of the first number and the
     *          index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (A == null || A.length < 1) {
            return ans;
        }

        int min = A[0];
        int max = A[0];
        for (int x : A) {
            if (x < min) {
                min = x;
            }

            if (x > max) {
                max = x;
            }
        }

        SegmentTreeNode node = build(min, max);

        for (int x : A) {
            ans.add(getValue(node, min, x - 1));
            insert(node, x, 1);
        }

        return ans;
    }

    private int getValue(SegmentTreeNode node, int start, int end) {
        if (node == null || end < node.start || start > node.end || start > end) {
            return 0;
        }
        start = Math.max(node.start, start);
        end = Math.min(node.end, end);
        if (start <= node.start && end >= node.end) {
            return node.value;
        }
        
        int mid = node.start + (node.end - node.start) / 2;
        
        return getValue(node.left, start, mid) + getValue(node.right, mid + 1, end);
    }

    private void insert(SegmentTreeNode node, int num, int value) {
        if (node == null || num < node.start || num > node.end) {
            return;
        }

        node.value += value;

        int mid = node.start + (node.end - node.start) / 2;

        if (num <= mid) {
            insert(node.left, num, value);
        }

        if (num > mid) {
            insert(node.right, num, value);
        }
    }

    private SegmentTreeNode build(int start, int end) {
        SegmentTreeNode ans = new SegmentTreeNode(start, end);
        if (start == end) {
            return ans;
        }

        int mid = start + (end - start) / 2;
        ans.left = build(start, mid);
        ans.right = build(mid + 1, end);

        return ans;
    }
}
