package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SimplifyPathTest {

    @Test
    public void testCase() {
        SimplifyPath s = new SimplifyPath();
        String ans = s.simplifyPath("/home/");
        assertEquals("/home", ans);
    }

    @Test
    public void testCase2() {
        SimplifyPath s = new SimplifyPath();
        String ans = s.simplifyPath("/a/./b/../../c/");
        assertEquals("/c", ans);
    }
}
