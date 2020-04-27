package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TextJustificationTest {

    @Test
    public void testCase() {
        TextJustification s = new TextJustification();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
