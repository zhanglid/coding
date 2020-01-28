package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PermutationInStringTest {

    @Test
    public void testCase() {
        PermutationInString s = new PermutationInString();
        boolean ans = s.checkInclusion("ab", "eidbaooo");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        PermutationInString s = new PermutationInString();
        boolean ans = s.checkInclusion("ab", "eidboaoo");
        assertEquals(false, ans);
    }
}
