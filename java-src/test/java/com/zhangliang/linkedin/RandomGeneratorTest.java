package com.zhangliang.linkedin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RandomGeneratorTest {

    @Test
    public void testCase() {
        RandomGenerator s = new RandomGenerator();
        int size = 10000;
        int[] result = new int[size];
        int oneSum = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = s.generate();
            if (result[i] == 1) {
                oneSum += 1;
            }
        }
        assertEquals(true, Math.abs(oneSum - size / 2) < 0.01 * size);
    }
}
