package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JumpGameTest {

    @Test
    public void testCase() {
        JumpGame s = new JumpGame();
        boolean ans = s.canJump(new int[] { 2, 3, 1, 1, 4 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        JumpGame s = new JumpGame();
        boolean ans = s.canJump(new int[] { 3, 2, 1, 0, 4 });
        assertEquals(false, ans);
    }
}
