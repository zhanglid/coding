package com.zhangliang.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(Integer[] arr) {
        val = arr[0];
        left = insertLevelOrder(arr, this, 1, true);
        right = insertLevelOrder(arr, this, 2, false);
    }

    private TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i, boolean isLeft) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }
        TreeNode temp = new TreeNode(arr[i]);
        root = temp;

        // insert left child
        root.left = insertLevelOrder(arr, root.left, i + (isLeft ? 2 : 1), isLeft);

        // insert right child
        root.right = insertLevelOrder(arr, root.right, i + (isLeft ? 2 : 3), isLeft);
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

    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();

        List<String> list = new ArrayList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add("null");
            } else {
                list.add(Integer.toString(node.val));
                if (node.left == null && node.right == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        while (list.get(list.size() - 1).equals("null")) {
            list.remove(list.size() - 1);
        }
        return list.toString();
    }
}
