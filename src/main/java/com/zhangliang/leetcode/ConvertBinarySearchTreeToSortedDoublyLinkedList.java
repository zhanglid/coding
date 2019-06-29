package com.zhangliang.leetcode;
/*
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and 
right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem 
better:

 
We want to transform this BST into a circular doubly linked list. Each node in a doubly 
linked list has a predecessor and successor. For a circular doubly linked list, the 
predecessor of the first element is the last element, and the successor of the last 
element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" 
symbol means the node it points to is the smallest element of the linked list.

 
Specifically, we want to do the transformation in place. After the transformation, 
the left pointer of the tree node should point to its predecessor, and the right 
pointer should point to its successor. We should return the pointer to the first 
element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor 
relationship, while the dashed line means the predecessor relationship.
*/

import com.zhangliang.utils.TreeNode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = treeToDoublyList(root.left);
        TreeNode right = treeToDoublyList(root.right);
        /**
         * 1. no left & no right connect itself and return.
         * 
         * 2. no left has right right side is greater than root, put root as head and
         * return root;
         * 
         * 3. no right has left left side is smaller than root. put root before head
         * return head;
         * 
         * 4. has both we can do 2 and connect right to the list.
         * 
         * Abstract: we have 3 circle to connect. left could be empty, root is a single
         * node circle, right also could be empty. combine three circles.
         */

        TreeNode head = root;

        // self circle.
        root.left = root;
        root.right = root;

        // left circle.
        if (left != null) {
            // update head
            head = left;
            TreeNode prev = left.left;
            prev.right = root;
            root.left = prev;
            root.right = left;
            left.left = root;
        }

        // right circle
        if (right != null) {
            TreeNode prev = head.left;
            TreeNode rightPrev = right.left;
            prev.right = right;
            right.left = prev;
            rightPrev.right = head;
            head.left = rightPrev;
        }

        return head;
    }
}
