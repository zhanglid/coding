package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SortCharactersByFrequencyTest {

    @Test
    public void testCase() {
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        String ans = s.frequencySort("tree");
        assertEquals("eert", ans);
    }

    // Input:
    // "cccaaa"

    // Output:
    // "cccaaa"
    @Test
    public void testCase2() {
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        String ans = s.frequencySort("cccaaa");
        assertEquals(true, ans.equals("cccaaa") || ans.equals("aaaccc"));
    }

    // Input:
    // "Aabb"

    // Output:
    // "bbAa"
    @Test
    public void testCase3() {
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        String ans = s.frequencySort("Aabb");
        assertEquals("bbAa", ans);
    }
}
