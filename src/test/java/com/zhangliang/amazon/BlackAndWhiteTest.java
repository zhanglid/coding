package com.zhangliang.amazon;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class BlackAndWhiteTest {

    @Test
    public void testCase() {
        int ans = BlackAndWhite.solve(new boolean[][] { 
            { false, false, true, false, true, false, false },
            { false, false, true, true, false, false, true }, 
            { true, false, false, true, true, false, true },
            { false, true, false, false, false, false, true }, 
            { false, false, false, false, false, true, true } 
        });
        assertEquals(3, ans);
    }
}
