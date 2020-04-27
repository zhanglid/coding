package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class StringTokenizeTest {

    @Test
    public void testCase() {
        StringTokenize s = new StringTokenize();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
