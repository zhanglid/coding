package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class StrobogrammaticNumberIITest {

    @Test
    public void testCase() {
        StrobogrammaticNumberII s = new StrobogrammaticNumberII();
        List<String> ans = s.findStrobogrammatic(2);
        assertArrayEquals(new String[] { "11", "69", "88", "96" }, ans.toArray(new String[0]));
    }

    @Test
    public void errCase() {
        StrobogrammaticNumberII s = new StrobogrammaticNumberII();
        List<String> ans = s.findStrobogrammatic(1);
        assertArrayEquals(new String[] { "0", "1", "8" }, ans.toArray(new String[0]));
    }

}
