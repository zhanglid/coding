package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void testCase() {
        RemoveNthNodeFromEndOfList s = new RemoveNthNodeFromEndOfList();
        ListNode ans = s.removeNthFromEnd(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
        assertEquals(ans.toString(), "1->2->3->5");
    }
}
