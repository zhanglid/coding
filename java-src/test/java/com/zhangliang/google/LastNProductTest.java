package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LastNProductTest {

    @Test
    public void testCase() {
        LastNProduct s = new LastNProduct();
        s.add(2);
        s.add(3);
        s.add(4);
        assertEquals(24, s.get(3));
        s.add(5);
        assertEquals(60, s.get(3));
    }
}
