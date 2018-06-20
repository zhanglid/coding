package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;
import com.zhangliang.utils.TreeLinkNode;

import org.junit.Test;

public class PopulatingNextRightPointersInEachNodeTest {

    @Test
    public void testCase() {
        PopulatingNextRightPointersInEachNode s = new PopulatingNextRightPointersInEachNode();
        TreeLinkNode input = TreeLinkNode.build(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }));
        s.connect(input);
        assertEquals(input, null);
    }
}
