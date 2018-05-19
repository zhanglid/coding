package com.zhangliang.leetcode;
/*
Merge k sorted linked lists and return it as one sorted list.
 Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(-1);
        if (lists == null || lists.length < 1) {
            return ans.next;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode node : lists) {
            pq.add(node);
        }

        ListNode cur = ans;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            if (cur.next.next != null)
                pq.add(cur.next.next);
            cur.next.next = null;
            cur = cur.next;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists s = new MergeKSortedLists();
        System.out.println(s.mergeKLists());
    }
}
