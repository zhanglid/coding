package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import com.zhangliang.Utils;
import org.junit.Test;

public class WordLadderIITest {

    @Test
    public void testCase() {
        WordLadderII s = new WordLadderII();
        List<List<String>> ans = s.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        String[] expecteds = new String[] { "[hit, hot, dot, dog, cog]", "[hit, hot, lot, log, cog]" };
        assertArrayEquals(expecteds, Utils.getStrsFrom2DList(ans));
    }

    @Test
    public void testCase2() {
        WordLadderII s = new WordLadderII();
        List<List<String>> ans = s.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        String[] expecteds = new String[] {};
        assertArrayEquals(expecteds, Utils.getStrsFrom2DList(ans));
    }

    @Test
    public void errCase() {
        WordLadderII s = new WordLadderII();
        List<List<String>> ans = s.findLadders("hot", "dog", Arrays.asList("hot", "dog"));
        String[] expecteds = new String[] {};
        assertArrayEquals(expecteds, Utils.getStrsFrom2DList(ans));
    }
}
