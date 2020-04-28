package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TopoSortTest {

    @Test
    public void testCase() {
        TopoSort s = new TopoSort();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
