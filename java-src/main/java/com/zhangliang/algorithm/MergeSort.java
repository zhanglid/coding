package com.zhangliang.algorithm;

import com.zhangliang.leetcode.ListNode;

/*
Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls 
itself for the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. 
The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted 
sub-arrays into one. See following C implementation for details.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
The following diagram from wikipedia shows the complete merge sort process for an example array {38, 27, 43, 3, 9, 82, 
    10}. If we take a closer look at the diagram, we can see that the array is recursively divided in two halves till the size 
    becomes 1. Once the size becomes 1, the merge processes comes into action and starts merging arrays back till the complete 
    array is merged.


                 1,3,5,7,9|,8,6,4,2,0                     
                 /                \                        o(1)
            1,3,5|,7,9          8,6,4|,2,0
            /       \             /   \                    o(2)
        1,3|,5      7,|9        8,6,|4    2,|0             
        /   \        / \         /  \      / \             o(4)
      1,3    5      7   9      8,6   4    2   0
      / \                      / \
     1   3                    8   6                        o(n/2)
    ==============================================
    13       5     79           86   4     20              o(n)
      \     /                 /     \     /
        135     79         6789          024               o(n)
          \              /           
               135689                                      o(n)
                 \                    /
                      01                                   o(n)


Time complexity: O(nlogn)
*/
public class MergeSort {

    public static class MergeSortLinkedList {
        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (left != null || right != null) {
                if (left != null && (right == null || left.val < right.val)) {
                    cur.next = left;
                    left = left.next;
                    cur = cur.next;
                    cur.next = null;
                } else {
                    cur.next = right;
                    right = right.next;
                    cur = cur.next;
                    cur.next = null;
                }
            }
            return dummy.next;
        }

        public ListNode sort(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow.next;
            slow.next = null;
            ListNode left = sort(head);
            ListNode right = sort(mid);

            return merge(left, right);
        }
    }

    public void sort(int[] arr) {
        sortRange(arr, 0, arr.length - 1);
    }

    public void sortRange(int[] arr, int l, int r) {
        if (arr == null || r - l < 1) {
            return;
        }

        int mid = l + (r - l) / 2;

        sortRange(arr, l, mid);
        sortRange(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int c1 = l;
        int c2 = mid + 1;
        int[] tmp = new int[r - l + 1];

        int index = 0;
        while (c1 <= mid || c2 <= r) {
            if (c2 > r || c1 <= mid && arr[c1] < arr[c2]) {
                tmp[index++] = arr[c1++];
            } else {
                tmp[index++] = arr[c2++];
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }
    }
}
