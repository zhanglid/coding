package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.leetcode.InsertIntoACyclicSortedList.Node;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class PopulatingNextRightPointersInEachNodeIITest {

    private Node makeTree(Integer[] nums) {
        if (nums == null) {
            return null;
        }
        Node root = new Node(nums[0]);

    }

    @Test
    public void testCase() {
        PopulatingNextRightPointersInEachNodeII s = new PopulatingNextRightPointersInEachNodeII();
        kNode input = TreeLinkNode.build(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, null, 7 }));
        s.connect(input);
        assertEquals(input, "");
    }
}
