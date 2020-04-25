package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.zhangliang.leetcode.FlattenAMultilevelDoublyLinkedList.Node;

import org.junit.Test;

public class FlattenAMultilevelDoublyLinkedListTest {

    private void assertCorrect(int[] vals, Node ans) {
        for (int i = 0; i < vals.length; i++) {
            assertNotNull(ans);
            assertEquals(vals[i], ans.val);
            ans = ans.next;
        }
    }

    @Test
    public void testCase() {
        FlattenAMultilevelDoublyLinkedList s = new FlattenAMultilevelDoublyLinkedList();
        Node node = new Node(new int[] { 1, 2, 3, 4, 5, 6 });
        Node second = new Node(new int[] { 7, 8, 9, 10 });
        Node third = new Node(new int[] { 11, 12 });

        node.next.next.child = second;
        second.next.child = third;
        Node ans = s.flatten(node);
        assertCorrect(new int[] { 1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6 }, ans);
    }
}
