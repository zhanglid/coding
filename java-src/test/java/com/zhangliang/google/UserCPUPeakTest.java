package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.google.UserCPUPeak.Log;

import org.junit.Test;

public class UserCPUPeakTest {

    @Test
    public void testCase() {
        UserCPUPeak s = new UserCPUPeak();
        Log[] inputs = new Log[]{
            new Log("abc", "1", 1, 5, 2),
            new Log("abc", "1", 2, 3, 4)
        };
        int ans = s.solve(inputs);
        assertEquals(6, ans);
    }
}
