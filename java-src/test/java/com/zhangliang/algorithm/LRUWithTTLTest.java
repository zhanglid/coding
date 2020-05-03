package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class LRUWithTTLTest {

    @Test
    public void testCase() {
        LRUWithTTL s = new LRUWithTTL();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
