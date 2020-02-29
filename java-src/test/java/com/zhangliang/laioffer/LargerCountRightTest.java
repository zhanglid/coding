package com.zhangliang.laioffer;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class LargerCountRightTest {

    @Test
    public void testCase() {
        LargerCountRight s = new LargerCountRight();
        int[] ans = s.count(new int[] { 4, 1, 3, 2 });
        assertArrayEquals(new int[] { 3, 0, 1, 0 }, ans);
    }
}
