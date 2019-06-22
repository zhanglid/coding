package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SimilarRgbColorTest {

    @Test
    public void testCase() {
        SimilarRgbColor s = new SimilarRgbColor();
        String ans = s.similarRGB("#09f166");
        assertEquals("#11ee66", ans);
    }
}
