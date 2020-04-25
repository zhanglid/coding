package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class RightViewOfBinaryTreeTest {

    @Test
    public void testCase() {
        RightViewOfBinaryTree s = new RightViewOfBinaryTree();
        List<Integer> ans = s.rightView(
                new TreeNode(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 9, null, null, null, null, 8, null, null, 10, 11 }));
        assertEquals(Arrays.asList(1, 3, 7, 8, 11).toString(), ans.toString());
    }
}
