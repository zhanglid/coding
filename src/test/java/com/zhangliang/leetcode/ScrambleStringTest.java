package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ScrambleStringTest {

    @Test
    public void testCase() {
        ScrambleString s = new ScrambleString();
        boolean ans = s.isScramble("great", "rgeat");
        assertEquals(ans, true);
    }

    @Test
    public void testCase2() {
        ScrambleString s = new ScrambleString();
        boolean ans = s.isScramble("abcde", "caebd");
        assertEquals(ans, false);
    }

    @Test
    public void errCase() {
        ScrambleString s = new ScrambleString();
        boolean ans = s.isScramble("abb", "bba");
        assertEquals(ans, true);
    }

    @Test
    public void errCase2() {
        ScrambleString s = new ScrambleString();
        boolean ans = s.isScramble("abcdefghijklmn", "efghijklmncadb");
        assertEquals(ans, false);
    }
}
