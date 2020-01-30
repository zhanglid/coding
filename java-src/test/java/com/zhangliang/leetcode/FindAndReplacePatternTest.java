package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class FindAndReplacePatternTest {

    @Test
    public void testCase() {
        FindAndReplacePattern s = new FindAndReplacePattern();
        List<String> ans = s.findAndReplacePattern(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb");
        assertArrayEquals(new String[] { "mee", "aqq" }, ans.toArray(new String[0]));
    }
}
