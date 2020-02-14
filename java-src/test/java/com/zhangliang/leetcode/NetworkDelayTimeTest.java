package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class NetworkDelayTimeTest {

    @Test
    public void testCase() {
        NetworkDelayTime s = new NetworkDelayTime();
        int ans = s.networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2);
        assertEquals(2, ans);
    }
}
