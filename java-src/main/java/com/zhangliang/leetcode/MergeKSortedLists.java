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

import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = new ListNode(node.val);
            cur = cur.next;
            node = node.next;
            if (node != null) {
                pq.add(node);
            }
        }
        return dummy.next;
    }
}
