package com.zhangliang.algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import com.zhangliang.leetcode.ListNode;

import org.junit.Test;

public class MergeSortTest {

    /**
     * Array
     */
    @Test
    public void testCase() {
        MergeSort s = new MergeSort();
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        s.sort(arr);
        assertArrayEquals(arr, new int[] { 5, 6, 7, 11, 12, 13 });
    }

    /**
     * LinkedList
     */
    @Test
    public void testCase2() {
        MergeSort.MergeSortLinkedList s = new MergeSort.MergeSortLinkedList();
        ListNode head = new ListNode(new int[] { 12, 11, 13, 5, 6, 7 });
        ListNode newHead = s.sort(head);
        assertEquals((new ListNode(new int[] { 5, 6, 7, 11, 12, 13 })).toString(), newHead.toString());
    }
}