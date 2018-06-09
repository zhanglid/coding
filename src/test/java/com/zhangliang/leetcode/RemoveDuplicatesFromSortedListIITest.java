package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemoveDuplicatesFromSortedListIITest {

    @Test
    public void testCase() {
        RemoveDuplicatesFromSortedListII s = new RemoveDuplicatesFromSortedListII();
        ListNode ans = s.deleteDuplicates(new ListNode(new int[] { 1, 2, 3, 3, 4, 4, 5 }));
        assertEquals("1->2->5", ans.toString());
    }

    @Test
    public void testCase2() {
        RemoveDuplicatesFromSortedListII s = new RemoveDuplicatesFromSortedListII();
        ListNode ans = s.deleteDuplicates(new ListNode(new int[] { 1, 1, 1, 2, 3 }));
        assertEquals("2->3", ans.toString());
    }
}
