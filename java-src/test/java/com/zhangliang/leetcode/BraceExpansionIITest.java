package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;
import org.junit.Test;

public class BraceExpansionIITest {

    @Test
    public void testCase() {
        BraceExpansionII s = new BraceExpansionII();
        List<String> ans = s.braceExpansionII("{a,b}{c,{d,e}}");
        assertArrayEquals(new String[] { "ac", "ad", "ae", "bc", "bd", "be" }, ans.toArray(new String[0]));
    }

    @Test
    public void testCase2() {
        BraceExpansionII s = new BraceExpansionII();
        List<String> ans = s.braceExpansionII("{{a,z},a{b,c},{ab,z}}");
        assertArrayEquals(new String[] { "a", "ab", "ac", "z" }, ans.toArray(new String[0]));
    }
}
