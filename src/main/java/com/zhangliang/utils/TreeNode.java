package com.zhangliang.utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(Integer[] arr) {
        val = arr[0];
        left = insertLevelOrder(arr, this, 1);
        right = insertLevelOrder(arr, this, 2);
    }

    private TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }
        TreeNode temp = new TreeNode(arr[i]);
        root = temp;

        // insert left child
        root.left = insertLevelOrder(arr, root.left, i + 1);

        // insert right child
        root.right = insertLevelOrder(arr, root.right, i + 2);
        return root;
    }

    public boolean equals(TreeNode other) {
        if (other == null) {
            return false;
        }

        if (other.val != val) {
            return false;
        }

        if (other.left == null && left != null) {
            return false;
        }

        if (other.right == null && right != null) {
            return false;
        }

        if (other.left != null && !other.left.equals(other.left)) {
            return false;
        }

        if (other.right != null && !other.right.equals(right)) {
            return false;
        }

        return true;
    }
}
