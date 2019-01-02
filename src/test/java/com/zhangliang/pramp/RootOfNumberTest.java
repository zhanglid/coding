package com.zhangliang.pramp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RootOfNumberTest {

    @Test
    public void testCase() {
        double ans = RootOfNumber.root(7, 3);
        assertEquals("1.913", String.format("%.3f", ans));
    }


    @Test
    public void testCase2() {
        double ans = RootOfNumber.root(9, 2);
        assertEquals("3", String.format("%.0f", ans));
    }
}
