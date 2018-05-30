package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JumpGameIITest {

    @Test
    public void testCase() {
        JumpGameII s = new JumpGameII();
        int ans = s.jump(new int[] { 2, 3, 1, 1, 4 });
        assertEquals(2, ans);
    }
}
