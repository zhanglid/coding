package com.zhangliang.leetcode;

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
        ListNode cur = next;
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append("->");

        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
            if (cur != null)
                sb.append("->");
        }

        return sb.toString();
    }
}