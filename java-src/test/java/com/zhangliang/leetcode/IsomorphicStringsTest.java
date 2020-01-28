package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class IsomorphicStringsTest {

    @Test
    public void testCase() {
        IsomorphicStrings s = new IsomorphicStrings();
        boolean ans = s.isIsomorphic("egg", "add");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        IsomorphicStrings s = new IsomorphicStrings();
        boolean ans = s.isIsomorphic("foo", "bar");
        assertEquals(false, ans);
    }

    @Test
    public void testCase3() {
        IsomorphicStrings s = new IsomorphicStrings();
        boolean ans = s.isIsomorphic("paper", "title");
        assertEquals(true, ans);
    }

    @Test
    public void errCase() {
        IsomorphicStrings s = new IsomorphicStrings();
        boolean ans = s.isIsomorphic("ab", "aa");
        assertEquals(false, ans);
    }
}
