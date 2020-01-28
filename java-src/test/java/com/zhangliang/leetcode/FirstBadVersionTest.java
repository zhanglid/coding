package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FirstBadVersionTest {

    @Test
    public void testCase() {
        FirstBadVersion s = new FirstBadVersion(4);
        int ans = s.firstBadVersion(5);
        assertEquals(4, ans);
    }
}
