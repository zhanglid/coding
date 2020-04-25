package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BulbSwitcherTest {
    @Test
    public void testCase() {
        BulbSwitcher s = new BulbSwitcher();
        int ans = s.bulbSwitch(3);
        assertEquals(1, ans);
    }
}
