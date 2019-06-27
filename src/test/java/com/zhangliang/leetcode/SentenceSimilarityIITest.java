package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SentenceSimilarityIITest {

    @Test
    public void testCase() {
        SentenceSimilarityII s = new SentenceSimilarityII();
        boolean ans = s.areSentencesSimilarTwo(new String[] { "great", "acting", "skills" },
                new String[] { "fine", "drama", "talent" },
                Arrays.asList(Arrays.asList("great", "good"), Arrays.asList("fine", "good"),
                        Arrays.asList("acting", "drama"), Arrays.asList("skills", "talent")));
        assertEquals(true, ans);
    }
}
