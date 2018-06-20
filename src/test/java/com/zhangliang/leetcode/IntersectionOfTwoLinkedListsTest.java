package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import org.junit.Test;

public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void testCase() {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        ListNode aList = new ListNode(new int[] { 1, 2 });
        ListNode bList = new ListNode(new int[] { -1, -2, -3 });
        ListNode rest = new ListNode(new int[] { 3, 4, 5 });
        aList.getLast().next = rest;
        bList.getLast().next = rest;
        ListNode ans = s.getIntersectionNode(aList, bList);
        assertEquals(ans.val, 3);
    }

    @Test
    public void errCase() {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        ListNode aList = new ListNode(new int[] { 1, 2 });
        ListNode bList = new ListNode(new int[] { -1, -2, -3 });
        ListNode ans = s.getIntersectionNode(aList, bList);
        assertEquals(ans, null);
    }
}
