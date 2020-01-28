package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RemoveLinkedListElementsTest {

    @Test
    public void testCase() {
        RemoveLinkedListElements s = new RemoveLinkedListElements();
        ListNode node = new ListNode(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        ListNode ans = s.removeElements(node, 6);
        assertEquals("1->2->3->4->5", ans.toString());
    }
}
