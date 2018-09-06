package com.zhangliang.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SegmentTreeNode {
    public int start, end;
    public int value;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }

    public String toString() {
        Queue<SegmentTreeNode> queue = new LinkedList<>();
        queue.add(this);
        List<String> strs = new ArrayList<>();
        while (!queue.isEmpty()) {
            SegmentTreeNode node = queue.poll();
            strs.add(Arrays.asList(node.start, node.end).toString());
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return strs.toString();
    }
}
