package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class DeleteNodeInABSTTest {

    @Test
    public void testCase() {
        DeleteNodeInABST s = new DeleteNodeInABST();
        TreeNode ans = s.deleteNode(new TreeNode(new Integer[] { 5, 3, 6, 2, 4, null, 7 }), 3);
        assertEquals(true, ans.toString().equals(Arrays.asList(5, 3, 6, 2, 4, null, 7).toString())
                || ans.toString().equals(Arrays.asList(5, 2, 6, null, 4, null, 7).toString()));
    }

    // [3,1,4,null,2]
    // 3

    @Test
    public void errCase() {
        DeleteNodeInABST s = new DeleteNodeInABST();
        TreeNode ans = s.deleteNode(new TreeNode(new Integer[] { 5, 3, 6, 2, 4, null, 7 }), 3);
        assertEquals(true, ans.toString().equals(Arrays.asList(5, 3, 6, 2, 4, null, 7).toString())
                || ans.toString().equals(Arrays.asList(5, 2, 6, null, 4, null, 7).toString()));
    }

    // [1,null,2]
    // 1
    @Test
    public void errCase2() {
        DeleteNodeInABST s = new DeleteNodeInABST();
        TreeNode ans = s.deleteNode(new TreeNode(new Integer[] { 1, null, 2 }), 1);
        assertEquals(true, ans.toString().equals(Arrays.asList(2).toString()));
    }
}
