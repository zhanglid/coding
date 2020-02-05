package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;

import com.zhangliang.leetcode.GuessTheWord.Master;

import org.junit.Test;

public class GuessTheWordTest {

    class TestMaster implements Master {
        public TestMaster() {

        }

        @Override
        public int guess(String word) {
            // TODO Auto-generated method stub
            return 0;
        }
    }

    @Test
    public void testCase() {
        GuessTheWord s = new GuessTheWord();
        String ans = s.findSecretWord(new int[][] {});
        assertEquals("", ans);
    }

    public void insertNode(ListNode head, int val) {
        if (head == null) {
            return;
        }
        ListNode cur = new ListNode(-1);
        cur.next = head;
        while (cur.next != null && cur.next.val < val) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = new ListNode(val);
        cur.next.next = next;
    }

}
