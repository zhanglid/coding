package com.zhangliang.algorithm;
/*

  Example
  Given start=0, end=3. The segment tree will be:

                [0,  3]
              /        \
        [0,  1]           [2, 3]
        /     \           /     \
    [0, 0]  [1, 1]     [2, 2]  [3, 3]
  Given start=1, end=6. The segment tree will be:

                [1,  6]
              /        \
        [1,  3]           [4,  6]
        /     \           /     \
    [1, 2]  [3,3]     [4, 5]   [6,6]
    /    \           /     \
  [1,1]   [2,2]     [4,4]   [5,5]

  https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/
*/

interface Merger {
  public int merge(int a, int b);

  public int rangeUpdate(int value, int delta, int lo, int hi);
}

public class SegmentTree {
  int size;
  int[] tree;
  int[] lazy;
  Merger merger;

  private int getTreeSize(int size) {
    int numOfLeaves = (int) Math.pow(2, Math.ceil(Math.log(size) / Math.log(2)));
    return 2 * numOfLeaves - 1;
  }

  private void build(int ti, int lo, int hi, int[] arr) {
    if (lo > hi) {
      return;
    }
    if (lo == hi) {
      tree[ti] = arr[lo];
      return;
    }
    int mid = lo + (hi - lo) / 2;
    int lti = 2 * ti + 1;
    int rti = 2 * ti + 2;
    build(lti, lo, mid, arr);
    build(rti, mid + 1, hi, arr);
    tree[ti] = merger.merge(tree[lti], tree[rti]);
  }

  public SegmentTree(int[] arr, Merger merger) {
    size = arr.length;
    int treeSize = getTreeSize(size);
    tree = new int[treeSize];
    lazy = new int[treeSize];
    this.merger = merger;
    build(0, 0, size - 1, arr);
  }

  private void resolveLazy(int ti, int tl, int tr) {
    int li = 2 * ti + 1;
    int ri = 2 * ti + 2;

    if (lazy[ti] != 0) {
      tree[ti] = merger.rangeUpdate(tree[ti], lazy[ti], tl, tr);
      if (li < tree.length) {
        lazy[li] += lazy[ti];
      }
      if (ri < tree.length) {
        lazy[ri] += lazy[ti];
      }
      lazy[ti] = 0;
    }
  }

  private int queryUtil(int ti, int tl, int tr, int lo, int hi) {
    if (lo > hi || lo > tr || hi < tl) {
      return 0;
    }

    int mid = tl + (tr - tl) / 2;
    int li = 2 * ti + 1;
    int ri = 2 * ti + 2;

    resolveLazy(ti, tl, tr);

    if (tl >= lo && tr <= hi) {
      return tree[ti];
    }
    return merger.merge(queryUtil(li, tl, mid, lo, hi), queryUtil(ri, mid + 1, tr, lo, hi));
  }

  public int query(int lo, int hi) {
    return queryUtil(0, 0, size - 1, lo, hi);
  }

  private void updateUtil(int ti, int tl, int tr, int index, int value) {
    if (index < tl || index > tr) {
      return;
    }

    int mid = tl + (tr - tl) / 2;
    int li = 2 * ti + 1;
    int ri = 2 * ti + 2;

    resolveLazy(ti, tl, tr);

    if (tl == tr && tl == index) {
      tree[ti] = value;
      return;
    }

    updateUtil(li, tl, mid, index, value);
    updateUtil(ri, mid + 1, tr, index, value);

    tree[ti] = merger.merge(tree[li], tree[ri]);
  }

  public void update(int index, int value) {
    updateUtil(0, 0, size - 1, index, value);
  }

  private void updateRangeUtil(int ti, int tl, int tr, int lo, int hi, int delta) {
    if (lo > hi || hi < tl || lo > tr) {
      return;
    }

    resolveLazy(ti, tl, tr);

    if (tl >= lo && tr <= hi) {
      lazy[ti] += delta;
      resolveLazy(ti, tl, tr);
      return;
    }

    int mid = tl + (tr - tl) / 2;
    int li = 2 * ti + 1;
    int ri = 2 * ti + 2;

    updateRangeUtil(li, tl, mid, lo, hi, delta);
    updateRangeUtil(ri, mid + 1, tr, lo, hi, delta);
    tree[ti] = merger.merge(tree[li], tree[ri]);
  }

  public void updateRange(int lo, int hi, int delta) {
    updateRangeUtil(0, 0, size - 1, lo, hi, delta);
  }
}
