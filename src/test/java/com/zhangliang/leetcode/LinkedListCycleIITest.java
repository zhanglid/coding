package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LinkedListCycleIITest {

    @Test
    public void testCase() {
        LinkedListCycleII s = new LinkedListCycleII();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = c;
        ListNode ans = s.detectCycle(a);
        assertEquals(c, ans);
    }
}
