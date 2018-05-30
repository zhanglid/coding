package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RotateListTest {

    @Test
    public void testCase() {
        RotateList s = new RotateList();
        ListNode input = new ListNode(new int[] { 1, 2, 3, 4, 5 });
        ListNode ans = s.rotateRight(input, 2);
        assertEquals("4->5->1->2->3", ans.toString());
    }

    @Test
    public void testCase2() {
        RotateList s = new RotateList();
        ListNode input = new ListNode(new int[] { 0, 1, 2 });
        ListNode ans = s.rotateRight(input, 4);
        assertEquals("2->0->1", ans.toString());
    }
}
