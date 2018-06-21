package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeLinkNode;
import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class PopulatingNextRightPointersInEachNodeIITest {

    @Test
    public void testCase() {
        PopulatingNextRightPointersInEachNodeII s = new PopulatingNextRightPointersInEachNodeII();
        TreeLinkNode input = TreeLinkNode.build(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, null, 7 }));
        s.connect(input);
        assertEquals(input, "");
    }
}
