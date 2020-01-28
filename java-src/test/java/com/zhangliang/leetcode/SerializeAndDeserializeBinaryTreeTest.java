package com.zhangliang.leetcode;

import static org.junit.Assert.assertTrue;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class SerializeAndDeserializeBinaryTreeTest {

    @Test
    public void testCase() {
        SerializeAndDeserializeBinaryTree.Codec s = new SerializeAndDeserializeBinaryTree.Codec();
        TreeNode oTree = new TreeNode(new Integer[] { 1, 2, 3, null, null, 4, 5 });
        String ans = s.serialize(oTree);
        TreeNode result = s.deserialize(ans);
        assertTrue(result.equals(oTree));
    }

    @Test
    public void errCase() {
        SerializeAndDeserializeBinaryTree.Codec s = new SerializeAndDeserializeBinaryTree.Codec();
        TreeNode oTree = null;
        String ans = s.serialize(oTree);
        TreeNode result = s.deserialize(ans);
        assertTrue(result == oTree || result.equals(oTree));
    }
}
