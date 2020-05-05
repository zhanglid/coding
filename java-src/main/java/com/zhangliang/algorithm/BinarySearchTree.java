package com.zhangliang.algorithm;
/*
  Implement the binary search tree
*/

public class BinarySearchTree {
  public static class Node {
    int key;
    Node left, right;

    public Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }

  Node root = null;

  private Node insertUtil(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }
    if (key < root.key) {
      root.left = insertUtil(root.left, key);
    } else {
      root.right = insertUtil(root.right, key);
    }
    return root;
  }

  public void insert(int key) {
    root = insertUtil(root, key);
  }

  private Node ceilingUtil(Node root, int key) {
    if (root == null) {
      return null;
    }
    Node res = null;
    if (root.key <= key) {
      res = ceilingUtil(root.right, key);
    } else {
      res = ceilingUtil(root.left, key);
    }

    return res == null && root.key <= key ? root : res;
  }

  public Integer ceiling(int key) {
    Node node = ceilingUtil(root, key);
    return node == null ? null : node.key;
  }

  private Node floorUtil(Node root, int key) {
    if (root == null) {
      return null;
    }

    Node res = null;

    if (key > root.key) {
      res = floorUtil(root.right, key);
    } else {
      res = floorUtil(root.left, key);
    }

    return res == null && root.key >= key ? root : res;
  }

  public Integer floor(int key) {
    Node node = floorUtil(root, key);
    return node == null ? null : node.key;
  }

}
