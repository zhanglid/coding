package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RepeatedStringMatchTest {

    @Test
    public void testCase() {
        RepeatedStringMatch s = new RepeatedStringMatch();
        int ans = s.repeatedStringMatch("abcd", "cdabcdab");
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        RepeatedStringMatch s = new RepeatedStringMatch();
        int ans = s.repeatedStringMatch("abc", "cabcabca");
        assertEquals(4, ans);
    }

    @Test
    public void errCase() {
        RepeatedStringMatch s = new RepeatedStringMatch();
        int ans = s.repeatedStringMatch("abcd", "abcdb");
        assertEquals(-1, ans);
    }

    @Test
    public void errCase2() {
        RepeatedStringMatch s = new RepeatedStringMatch();
        int ans = s.repeatedStringMatch("a", "aa");
        assertEquals(2, ans);
    }

    @Test
    public void errCase3() {
        RepeatedStringMatch s = new RepeatedStringMatch();
        int ans = s.repeatedStringMatch("abcd", "bcdab");
        assertEquals(2, ans);
    }
}
