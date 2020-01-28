package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SentenceScreenFittingTest {

    @Test
    public void testCase() {
        /*
         * hello--- world---
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "hello", "world" }, 2, 8);
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        /*
         * a-bcd- e-a--- bcd-e-
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "a", "bcd", "e" }, 3, 6);
        assertEquals(2, ans);
    }

    @Test
    public void testCase3() {
        /*
         * I-had apple pie-I had--
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "I", "had", "apple", "pie" }, 4, 5);
        assertEquals(1, ans);
    }

    @Test
    public void errCase() {
        /*
         * h e l l o
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "hello" }, 10000, 1);
        assertEquals(0, ans);
    }

    @Test
    public void errCase2() {
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "f", "p", "a" }, 8, 7);
        assertEquals(10, ans);
    }

    @Test
    public void errCase3() {
        /*
         * a-bcd- e-a--- bcd-e- a-bcd-
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "a", "bcd", "e" }, 4, 6);
        assertEquals(2, ans);
    }

    @Test
    public void errCase4() {
        /*
         * a b c
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "a", "b", "c" }, 3, 1);
        assertEquals(1, ans);
    }

    @Test
    public void errCase5() {
        /*
         * h-h h-h
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "h" }, 2, 3);
        assertEquals(4, ans);
    }

    @Test
    public void errCase6() {
        /*
         * hello world
         */
        SentenceScreenFitting s = new SentenceScreenFitting();
        int ans = s.wordsTyping(new String[] { "hello", "world" }, 10000, 9);
        assertEquals(5000, ans);
    }
}
