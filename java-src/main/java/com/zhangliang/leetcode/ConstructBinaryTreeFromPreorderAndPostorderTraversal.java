package com.zhangliang.leetcode;
/*
Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 

Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.

*/

import com.zhangliang.utils.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null) {
            return null;
        }

        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode helper(int[] pre, int s1, int e1, int[] post, int s2, int e2) {
        if (s1 > e1 || s2 > e2 || e1 >= pre.length || e2 >= post.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[s1]);

        int index = s2;
        while (index < e2 && post[index] != pre[s1 + 1]) {
            index++;
        }

        if (index == e2) {
            return root;
        }

        root.left = helper(pre, s1 + 1, index - s2 + s1 + 1, post, s2, index);
        root.right = helper(pre, index - s2 + s1 + 2, e1, post, index + 1, e2 - 1);

        return root;
    }
}
