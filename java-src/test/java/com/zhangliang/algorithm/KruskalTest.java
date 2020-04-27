package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class KruskalTest {

    @Test
    public void testCase() {
        Kruskal s = new Kruskal();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
