package com.zhangliang.utils;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }

    public static TreeLinkNode build(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeLinkNode root = new TreeLinkNode(node.val);

        root.left = build(node.left);
        root.right = build(node.right);

        return root;
    }

    public boolean equals(TreeLinkNode root) {
        if (root == null) {
            return false;
        }
        return (val == root.val) && (root.next == null && next == null || root.next.equals(next))
                && (root.left == null && left == null || root.left.equals(left))
                && (root.right == null && right == null || root.right.equals(right));
    }
}