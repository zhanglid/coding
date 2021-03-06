package com.zhangliang.leetcode;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

//  Definition for singly-linked list.

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int step = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null || step != 0) {
            int result = ( l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            result += step;
            cur.next = new ListNode(result % 10);
            step = result / 10;

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
       
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);
        
        ListNode ans = s.addTwoNumbers(l1, l2);
        
        while(ans != null) {
            System.out.print(ans.val);
            if (ans.next != null) {
                System.out.print("->");
            }

            ans = ans.next;
        }
    }
}