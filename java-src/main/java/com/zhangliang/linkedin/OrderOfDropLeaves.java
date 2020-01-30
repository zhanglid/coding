package com.zhangliang.linkedin;
/*
有一棵树 求落叶子的顺序。 叶子落下的条件是该叶子没有 children。
输入是一个 treeNode， 输出一个List<Set<TreeNode>>
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class OrderOfDropLeaves {
    private int dfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        int lDepth = dfs(root.left, result);
        int rDepth = dfs(root.right, result);
        int depth = Math.max(lDepth, rDepth) + 1;

        if (depth >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(root.val);
        return depth;
    }

    public List<Integer> getDropLeavesOrder(TreeNode root) {
        List<List<Integer>> valuesByDepth = new ArrayList<>();
        dfs(root, valuesByDepth);
        List<Integer> result = new ArrayList<>();
        for (List<Integer> values : valuesByDepth) {
            result.addAll(values);
        }
        return result;
    }
}
