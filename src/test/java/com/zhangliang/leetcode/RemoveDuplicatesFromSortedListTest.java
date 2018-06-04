package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void testCase() {
        RemoveDuplicatesFromSortedList s = new RemoveDuplicatesFromSortedList();
        ListNode ans = s.deleteDuplicates(new ListNode(new int[] { 1, 1, 2 }));
        assertEquals("1->2", ans.toString());
    }

    @Test
    public void testCase2() {
        RemoveDuplicatesFromSortedList s = new RemoveDuplicatesFromSortedList();
        ListNode ans = s.deleteDuplicates(new ListNode(new int[] { 1, 1, 2, 3, 3 }));
        assertEquals("1->2->3", ans.toString());
    }
}
