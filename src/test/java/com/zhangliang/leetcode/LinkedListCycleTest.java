package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LinkedListCycleTest {

    @Test
    public void testCase() {
        LinkedListCycle s = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        boolean ans = s.hasCycle(head);
        assertEquals(ans, true);
    }

    @Test
    public void errCase() {
        LinkedListCycle s = new LinkedListCycle();
        ListNode head = new ListNode(1);
        boolean ans = s.hasCycle(head);
        assertEquals(ans, false);
    }

    @Test
    public void errCase2() {
        LinkedListCycle s = new LinkedListCycle();
        ListNode head = null;
        boolean ans = s.hasCycle(head);
        assertEquals(ans, false);
    }
}
