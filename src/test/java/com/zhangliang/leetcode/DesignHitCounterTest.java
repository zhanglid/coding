package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DesignHitCounterTest {

    @Test
    public void testCase() {
        DesignHitCounter.HitCounter counter = new DesignHitCounter.HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        assertEquals(3, counter.getHits(4));

        counter.hit(300);
        assertEquals(4, counter.getHits(300));
        assertEquals(3, counter.getHits(301));
    }
}
