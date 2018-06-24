package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.RandomListNode;

import org.junit.Test;

public class CopyListWithRandomPointerTest {

    @Test
    public void testCase() {
        CopyListWithRandomPointer s = new CopyListWithRandomPointer();
        RandomListNode inputNode = new RandomListNode(-1);
        inputNode.next = new RandomListNode(-1);
        inputNode.random = inputNode.next;
        RandomListNode ans = s.copyRandomList(inputNode);
        assertEquals(ans, ans);
    }
}
