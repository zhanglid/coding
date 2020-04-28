package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RandomShuffleTest {

    @Test
    public void testCase() {
        RandomShuffle s = new RandomShuffle();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
