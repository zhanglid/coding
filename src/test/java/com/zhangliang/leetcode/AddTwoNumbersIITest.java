package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddTwoNumbersIITest {

    @Test
    public void testCase() {
        AddTwoNumbersII s = new AddTwoNumbersII();
        ListNode ans = s.addTwoNumbers(new ListNode(new int[] { 7, 2, 4, 3 }), new ListNode(new int[] { 5, 6, 4 }));
        assertEquals("7->8->0->7", ans.toString());
    }
}
