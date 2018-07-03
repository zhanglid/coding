package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ReorderListTest {

    @Test
    public void testCase() {
        ReorderList s = new ReorderList();
        ListNode input = new ListNode(new int[] { 1, 2, 3, 4 });
        s.reorderList(input);
        assertEquals("1->4->2->3", input.toString());
    }

    @Test
    public void testCase2() {
        ReorderList s = new ReorderList();
        ListNode input = new ListNode(new int[] { 1, 2, 3, 4, 5 });
        s.reorderList(input);
        assertEquals("1->5->2->4->3", input.toString());
    }
}
