package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BaseConversionTest {

    @Test
    public void testCase() {
        BaseConversion s = new BaseConversion();
        String ans = s.solve("1A", 16, 2);
        assertEquals("11010", ans);
    }

    @Test
    public void testCase2() {
        BaseConversion s = new BaseConversion();
        String ans = s.solve("1A", 16, 8);
        assertEquals("32", ans);
    }
}
