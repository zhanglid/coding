package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PermutationSequenceTest {

    @Test
    public void testCase() {
        PermutationSequence s = new PermutationSequence();
        String ans = s.getPermutation(3, 3);
        assertEquals("213", ans);
    }

    @Test
    public void testCase2() {
        PermutationSequence s = new PermutationSequence();
        String ans = s.getPermutation(4, 9);
        assertEquals("2314", ans);
    }
}
