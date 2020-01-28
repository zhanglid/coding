package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class BinaryTreePostorderTraversalTest {

    @Test
    public void testCase() {
        BinaryTreePostorderTraversal s = new BinaryTreePostorderTraversal();
        List<Integer> ans = s.postorderTraversal(new TreeNode(new Integer[] { 1, null, 2, 3 }));
        assertArrayEquals(new Integer[] { 3, 2, 1 }, ans.toArray(new Integer[0]));
    }
}
