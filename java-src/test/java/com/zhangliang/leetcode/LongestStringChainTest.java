package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class LongestStringChainTest {

    @Test
    public void testCase() {
        LongestStringChain s = new LongestStringChain();
        int ans = s.longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" });
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        LongestStringChain s = new LongestStringChain();
        int ans = s.longestStrChain(
                new String[] { "ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh",
                        "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru" });
        assertEquals(7, ans);
    }
}
