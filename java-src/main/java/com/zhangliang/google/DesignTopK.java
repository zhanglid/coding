package com.zhangliang.google;
/*
  写一种数据结构有findRank(k) 和 add(num)两种方法，findRank就是找到第k个大的数子，
  add就是加数字进去。很简单的topk方法，讨论了很多种。值得注意的是加重复数字的case
  https://www.cs.yale.edu/homes/aspnes/pinewiki/OrderStatisticsTree.html
*/

public class DesignTopK {
  class Node {
    Node left, right;
    int key;
    int height;
    int rank;
    int count;
    int size;

    public Node(int key) {
      this.key = key;
      this.rank = 1;
      this.count = 1;
      this.size = 1;
      this.height = 0;
    }
  }

  Node root = null;

  private int height(Node root) {
    return root == null ? 0 : root.height;
  }

  private int size(Node root) {
    return root == null ? 0 : root.size;
  }

  private void refreshSize(Node root) {
    root.size = size(root.left) + size(root.right) + root.count;
  }

  /*
    @formatter:off

             x                  y
            / \               /   \
           y   t1    ->      t2    x
          / \                     / \
         t2  t3                  t3  t1

    @formatter:on
   */
  private Node rightRotate(Node x) {
    Node y = x.left;
    Node t3 = y.right;

    y.right = x;
    x.left = t3;

    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    refreshSize(x);
    refreshSize(y);

    x.rank = t3.size + x.count;

    return y;
  }

  /*
    @formatter:off

             x                       y
            / \                     / \
           t1  y         ->        x   t3
              / \                 / \
             t2  t3              t1 t2

    @formatter:on
   */
  private Node leftRotate(Node x) {
    Node y = x.right;
    Node t2 = y.left;

    y.left = x;
    x.right = t2;

    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    refreshSize(x);
    refreshSize(y);

    y.rank = x.size + y.count;

    return y;
  }

  private Node balance(Node root, int key) {
    int lh = height(root.left);
    int rh = height(root.right);

    int diff = lh - rh;

    // ll
    if (diff > 1 && root.left.key > key) {
      return rightRotate(root);
    }

    // lr
    if (diff > 1 && root.left.key < key) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    // rr
    if (diff < -1 && root.right.key < key) {
      return leftRotate(root);
    }

    // rl
    if (diff < -1 && root.right.key > key) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

    return root;
  }

  private Node insert(Node root, int key) {
    if (root == null) {
      root = new Node(key);
    } else if (root.key == key) {
      root.rank++;
      root.count++;
    } else if (key > root.key) {
      root.right = insert(root.right, key);
    } else {
      root.rank++;
      root.left = insert(root.left, key);
    }

    root.height = Math.max(height(root.left), height(root.right)) + 1;
    refreshSize(root);

    return balance(root, key);
  }

  private Node findRankUtil(Node root, int k) {
    if (root == null || k < 1) {
      return null;
    }
    Node res = null;
    if (root.rank >= k) {
      res = findRankUtil(root.left, k);
    } else if (root.rank < k) {
      res = findRankUtil(root.right, k - root.rank);
    }

    if (res == null && root.rank >= k) {
      res = root;
    }

    return res;
  }

  public int findRank(int k) {
    Node node = findRankUtil(root, k);
    return node == null ? 0 : node.key;
  }

  public void add(int num) {
    this.root = insert(root, num);
  }
}
