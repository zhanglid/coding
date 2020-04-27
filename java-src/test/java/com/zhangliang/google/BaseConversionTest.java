package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class BaseConversionTest {

    @Test
    public void testCase() {
        BaseConversion s = new BaseConversion();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
