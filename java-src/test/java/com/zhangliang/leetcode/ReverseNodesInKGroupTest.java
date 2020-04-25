package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReverseNodesInKGroupTest {

    @Test
    public void testCase() {
        ReverseNodesInKGroup s = new ReverseNodesInKGroup();
        ListNode ans = s.reverseKGroup(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
        assertEquals(ans.toString(), "2->1->4->3->5");
    }

    @Test
    public void testCase2() {
        ReverseNodesInKGroup s = new ReverseNodesInKGroup();
        ListNode ans = s.reverseKGroup(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 3);
        assertEquals(ans.toString(), "3->2->1->4->5");
    }

    @Test
    public void errCase() {
        ReverseNodesInKGroup s = new ReverseNodesInKGroup();
        ListNode ans = s.reverseKGroup(new ListNode(new int[] { 1 }), 1);
        assertEquals(ans.toString(), "1");
    }
}
