package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class WordLadderTest {

    @Test
    public void testCase() {
        WordLadder s = new WordLadder();
        int ans = s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        WordLadder s = new WordLadder();
        int ans = s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        assertEquals(0, ans);
    }
}
