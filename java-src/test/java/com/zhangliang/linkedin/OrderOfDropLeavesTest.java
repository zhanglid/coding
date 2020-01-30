package com.zhangliang.linkedin;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class OrderOfDropLeavesTest {

    @Test
    public void testCase() {
        OrderOfDropLeaves s = new OrderOfDropLeaves();
        List<Integer> ans = s.getDropLeavesOrder(new TreeNode(new Integer[] { 1, 2, 3 }));
        assertArrayEquals(new Integer[] { 2, 3, 1 }, ans.toArray(new Integer[0]));
    }

    @Test
    public void testCase2() {
        OrderOfDropLeaves s = new OrderOfDropLeaves();
        List<Integer> ans = s.getDropLeavesOrder(new TreeNode(new Integer[] { 1, null, 2, null, 3 }));
        assertArrayEquals(new Integer[] { 3, 2, 1 }, ans.toArray(new Integer[0]));
    }
}
