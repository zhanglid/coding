package com.zhangliang.leetcode;

import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] nums) {
        val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
    }

    public String toString() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();
        Set<ListNode> visited = new HashSet<>();
        while (cur != null && !visited.contains(cur)) {
            sb.append(cur.val);
            visited.add(cur);
            cur = cur.next;
            if (cur != null)
                sb.append("->");
        }

        return sb.toString();
    }

    public ListNode getLast() {
        ListNode cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }

        return cur;
    }
}