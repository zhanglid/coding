package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MergeKSortedListsTest {

    @Test
    public void testCase() {
        MergeKSortedLists s = new MergeKSortedLists();
        ListNode[] input = new ListNode[3];
        input[0] = new ListNode(new int[] { 1, 4, 5 });
        input[1] = new ListNode(new int[] { 1, 3, 4 });
        input[2] = new ListNode(new int[] { 2, 6 });
        ListNode ans = s.mergeKLists(input);
        assertEquals("1->1->2->3->4->4->5->6", ans.toString());
    }

    @Test
    public void errCase() {
        MergeKSortedLists s = new MergeKSortedLists();
        ListNode[] input = new ListNode[1];
        ListNode ans = s.mergeKLists(input);
        assertEquals(null, ans);
    }
}
