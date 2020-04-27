package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SplitStringByCharFrequencyTest {

    @Test
    public void testCase() {
        SplitStringByCharFrequency s = new SplitStringByCharFrequency();
        int ans = s.split("aabaab");
        assertEquals(2, ans);
    }
}
