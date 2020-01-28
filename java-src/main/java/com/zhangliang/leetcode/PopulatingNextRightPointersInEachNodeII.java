package com.zhangliang.leetcode;
/*
Given a binary tree

struct Node {
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

*/

import java.util.*;

public class PopulatingNextRightPointersInEachNodeII {
  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }

    public Node() {

    }
  };

  public Node connect(Node root) {
    Queue<Node> queue = new LinkedList<>();
    if (root == null) {
      return root;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node prev = null;
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        if (prev != null) {
          prev.next = node;
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        prev = node;
      }
    }
    return root;
  }
}
