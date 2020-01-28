package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MergeTwoSortedListsTest {
    private void assertCorrect(ListNode expected, ListNode actual) {
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testCase() {
        MergeTwoSortedLists s = new MergeTwoSortedLists();
        ListNode ans = s.mergeTwoLists(new ListNode(new int[] { 1, 2, 4 }), new ListNode(new int[] { 1, 3, 4 }));
        assertCorrect(new ListNode(new int[] { 1, 1, 2, 3, 4, 4 }), ans);
    }
}
