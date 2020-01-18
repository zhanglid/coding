package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

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
        assertEquals(3, ans.val);
    }

    @Test
    public void errCase() {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        ListNode aList = new ListNode(new int[] { 1, 2 });
        ListNode bList = new ListNode(new int[] { -1, -2, -3 });
        ListNode ans = s.getIntersectionNode(aList, bList);
        assertEquals(null, ans);
    }

    @Test
    public void errCase2() {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        ListNode aList = new ListNode(new int[] { 2, 6, 4 });
        ListNode bList = new ListNode(new int[] { 1, 5 });
        ListNode ans = s.getIntersectionNode(aList, bList);
        assertEquals(null, ans);
    }

    @Test
    public void errCase3() {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        ListNode aList = new ListNode(new int[] { 2, 6, 4 });
        ListNode bList = null;
        ListNode ans = s.getIntersectionNode(aList, bList);
        assertEquals(null, ans);
    }

    @Test
    public void errCase4() {
        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        ListNode aList = new ListNode(new int[] { 3 });
        ListNode bList = new ListNode(new int[] { 2 });
        bList.getLast().next = aList;
        ListNode ans = s.getIntersectionNode(aList, bList);
        assertEquals(3, ans.val);
    }

}
