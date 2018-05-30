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

    @Test
    public void errCase() {
        JumpGameII s = new JumpGameII();
        int ans = s.jump(new int[] { 1 });
        assertEquals(0, ans);
    }

    @Test
    public void errCase2() {
        JumpGameII s = new JumpGameII();
        int ans = s.jump(new int[] { 7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3 });
        assertEquals(2, ans);
    }
}
