package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InsertionSortListTest {

    @Test
    public void testCase() {
        InsertionSortList s = new InsertionSortList();
        ListNode ans = s.insertionSortList(new ListNode(new int[] { 4, 2, 1, 3 }));
        assertEquals("1->2->3->4", ans.toString());
    }

    @Test
    public void testCase2() {
        InsertionSortList s = new InsertionSortList();
        ListNode ans = s.insertionSortList(new ListNode(new int[] { -1, 5, 3, 4, 0 }));
        assertEquals("-1->0->3->4->5", ans.toString());
    }
}
