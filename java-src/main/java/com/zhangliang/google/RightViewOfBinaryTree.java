package com.zhangliang.google;
/*
*/

import java.util.*;

import com.zhangliang.utils.*;

public class RightViewOfBinaryTree {
    private void helper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }

        // Add if it is the first in the level.
        if (level >= result.size()) {
            result.add(root.val);
        }

        // Go with right child first.
        helper(root.right, level + 1, result);
        helper(root.left, level + 1, result);
    }

    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }
}
