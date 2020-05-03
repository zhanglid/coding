package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReservoirSamplingTest {

    @Test
    public void testCase() {
        ReservoirSampling s = new ReservoirSampling(new int[] { 1, 2, 3, 4, 5 });
        int[] ans = s.sample(2);
        assertEquals(2, ans.length);
    }

    @Test
    public void testCase2() {
        ReservoirSampling s = new ReservoirSampling(new int[] { 1, 2, 3, 4, 5 });
        int count = 3000000;
        int rest = count;
        int hit = 0;
        while (rest-- > 0) {
            int[] ans = s.sample(2);
            if (ans[0] == 1 || ans[1] == 1) {
                hit++;
            }
        }
        assertEquals(0.4, (double) hit / count, 0.001);
    }
}
