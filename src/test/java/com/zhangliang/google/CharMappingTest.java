package com.zhangliang.google;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CharMappingTest {

    @Test
    public void testCase() {
        CharMapping s = new CharMapping();
        boolean ans = s.canMapping("abc", "edf");
        assertEquals(ans, true);
    }

    @Test
    public void testCase2() {
        CharMapping s = new CharMapping();
        boolean ans = s.canMapping("abc", "edd");
        assertEquals(ans, true);
    }

    @Test
    public void testCase3() {
        CharMapping s = new CharMapping();
        boolean ans = s.canMapping("aba", "def");
        assertEquals(ans, false);
    }

    @Test
    // ab => bc
    // a -> b -> c
    public void testCase4() {
        CharMapping s = new CharMapping();
        List<String> ans = s.getPath("aba", "def");
        assertArrayEquals(ans.toArray(new String[0]), new String[] { "aba", "def" });
    }

    @Test
    // f => a <= d 
    public void testCase5() {
        CharMapping s = new CharMapping();
        boolean ans = s.isAdditionalMappingRequiredTopo("ab", "ba");
        assertEquals(true, ans);
    }
}
