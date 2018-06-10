package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PartitionListTest {

    @Test
    public void testCase() {
        PartitionList s = new PartitionList();
        ListNode ans = s.partition(new ListNode(new int[] { 1, 4, 3, 2, 5, 2 }), 3);
        assertEquals("1->2->2->4->3->5", ans.toString());
    }

    @Test
    public void testCase2() {
        PartitionList s = new PartitionList();
        ListNode ans = s.partition(new ListNode(new int[] { 1, 1 }), 2);
        assertEquals("1->1", ans.toString());
    }
}
