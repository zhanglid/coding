package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class RepeatedDNASequencesTest {

    @Test
    public void testCase() {
        RepeatedDNASequences s = new RepeatedDNASequences();
        List<String> ans = s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        String[] expected = new String[] { "AAAAACCCCC", "CCCCCAAAAA" };
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void errCase() {
        RepeatedDNASequences s = new RepeatedDNASequences();
        List<String> ans = s.findRepeatedDnaSequences("AAAAAAAAAAAA");
        String[] expected = new String[] { "AAAAAAAAAA" };
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }
}
