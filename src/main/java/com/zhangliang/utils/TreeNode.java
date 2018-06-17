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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        for (int i = 1; i < arr.length; i++) {
            TreeNode node = queue.poll();
            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }

            if (i + 1 >= arr.length) {
                break;
            }

            if (arr[i + 1] != null) {
                node.right = new TreeNode(arr[i + 1]);
                queue.add(node.right);
            }

            i++;
        }
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
