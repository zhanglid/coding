package com.zhangliang.laioffer;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ReversedMergeAbcdTest {

    @Test
    public void testCase() {
        ReversedMergeAbcd s = new ReversedMergeAbcd();
        String ans = s.sort("ABCD1234");
        assertEquals("A1B2C3D4", ans);
    }
}
