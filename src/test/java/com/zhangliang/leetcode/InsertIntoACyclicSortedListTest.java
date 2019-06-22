package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.leetcode.InsertIntoACyclicSortedList.Node;

import org.junit.Test;

public class InsertIntoACyclicSortedListTest {

    private Node toNodeList(int[] nums, int headNum) {
        Node dummy = new Node(-1, null);
        Node cur = dummy;
        Node head = null;
        for (int num : nums) {
            cur.next = new Node(num, null);
            cur = cur.next;
            if (num == headNum) {
                head = cur;
            }
        }
        cur.next = dummy.next;
        return head;
    }

    @Test
    public void testCase() {
        InsertIntoACyclicSortedList s = new InsertIntoACyclicSortedList();
        Node ans = s.insert(toNodeList(new int[] { 1, 3, 4 }, 3), 2);
        assertEquals(toNodeList(new int[] { 1, 2, 3, 4 }, 3), ans);
    }
}
