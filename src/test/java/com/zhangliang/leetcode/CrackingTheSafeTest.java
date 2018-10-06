package com.zhangliang.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CrackingTheSafeTest {

    @Test
    public void testCase() {
        CrackingTheSafe s = new CrackingTheSafe();
        String ans = s.crackSafe(1, 2);
        assertTrue("01".equals(ans) || "10".equals(ans));
    }

    @Test
    public void testCase2() {
        CrackingTheSafe s = new CrackingTheSafe();
        String ans = s.crackSafe(2, 2);
        assertTrue("00110".equals(ans) || "01100".equals(ans) || "10011".equals(ans) || "11001".equals(ans));
    }

    @Test
    public void tleCase() {
        CrackingTheSafe s = new CrackingTheSafe();
        String ans = s.crackSafe(2, 4);
        assertTrue("03322312113020100".length() == ans.length());
    }
}
