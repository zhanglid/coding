package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SentenceSimilarityTest {

    @Test
    public void testCase() {
        SentenceSimilarity s = new SentenceSimilarity();
        boolean ans = s.areSentencesSimilar(new String[] { "great", "acting", "skills" },
                new String[] { "fine", "drama", "talent" }, Arrays.asList(Arrays.asList("great", "fine"),
                        Arrays.asList("acting", "drama"), Arrays.asList("skills", "talent")));
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        SentenceSimilarity s = new SentenceSimilarity();
        boolean ans = s.areSentencesSimilar(new String[] { "great" }, new String[] { "great" }, Arrays.asList());
        assertEquals(true, ans);
    }
}
