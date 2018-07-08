package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RepeatedDNASequencesTest {

    @Test
    public void testCase() {
        RepeatedDNASequences s = new RepeatedDNASequences();
        List<String> ans = s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        String[] expected = new String[] { "AAAAACCCCC", "CCCCCAAAAA" };
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }
}
