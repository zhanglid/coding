package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ReverseLinkedListIITest {

    @Test
    public void testCase() {
        ReverseLinkedListII s = new ReverseLinkedListII();
        ListNode ans = s.reverseBetween(new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2, 4);
        assertEquals("1->4->3->2->5", ans.toString());
    }
}
