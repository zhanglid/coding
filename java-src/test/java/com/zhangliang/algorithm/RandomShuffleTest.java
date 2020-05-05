package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RandomShuffleTest {
    @Test
    public void testCase() {
        RandomShuffle s = new RandomShuffle();
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        s.shuffle(input);
        assertEquals(5, input.length);
    }
}
