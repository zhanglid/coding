package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SwapNodesInPairsTest {

    @Test
    public void testCase() {
        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode ans = s.swapPairs(new ListNode(new int[] { 1, 2, 3, 4 }));
        assertEquals("2->1->4->3", ans.toString());
    }
}
