package com.zhangliang.laioffer;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MergeAbcdTest {

    @Test
    public void testCase() {
        MergeAbcd s = new MergeAbcd();
        String ans = s.transform("A1B2C3D4");
        assertEquals("ABCD1234", ans);
    }
}
