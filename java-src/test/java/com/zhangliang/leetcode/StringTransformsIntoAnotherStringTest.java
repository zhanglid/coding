package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringTransformsIntoAnotherStringTest {
    @Test
    public void testCase() {
        StringTransformsIntoAnotherString s = new StringTransformsIntoAnotherString();
        boolean ans = s.canConvert("aabcc", "ccdee");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        StringTransformsIntoAnotherString s = new StringTransformsIntoAnotherString();
        boolean ans = s.canConvert("leetcode", "codeleet");
        assertEquals(false, ans);
    }

    /**
     * Wrong way to check the full-circle. "abcdefghijklmnopqrstuvwxyz"
     * "bcdefghijklmnopqrstuvwxyza"
     */
    @Test
    public void errCase() {
        StringTransformsIntoAnotherString s = new StringTransformsIntoAnotherString();
        boolean ans = s.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza");
        assertEquals(false, ans);
    }

    /**
     * Missed the case that it could have several circles to cover all lower cases.
     * "abcdefghijklmnopqrstuvwxyz" "bcdefghijkamnopqrstuvwxyzl"
     */
    @Test
    public void errCase2() {
        StringTransformsIntoAnotherString s = new StringTransformsIntoAnotherString();
        boolean ans = s.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijkamnopqrstuvwxyzl");
        assertEquals(false, ans);
    }

    /**
     * Self to self circle.
     */
    @Test
    public void errCase3() {
        StringTransformsIntoAnotherString s = new StringTransformsIntoAnotherString();
        boolean ans = s.canConvert("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz");
        assertEquals(true, ans);
    }
}
