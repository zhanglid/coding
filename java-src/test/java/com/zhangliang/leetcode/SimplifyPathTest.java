package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void errCase() {
        SimplifyPath s = new SimplifyPath();
        String ans = s.simplifyPath("/abc/...");
        assertEquals("/abc/...", ans);
    }

    @Test
    public void errCase2() {
        SimplifyPath s = new SimplifyPath();
        String ans = s.simplifyPath("/../");
        assertEquals("/", ans);
    }
}
