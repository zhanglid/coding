package com.zhangliang.google;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class RemainPolesTest {

    @Test
    public void testCase() {
        RemainPoles s = new RemainPoles();
        int[] ans = s.solve(new int[] { 3, 3, 7, 2 });
        assertArrayEquals(new int[] { 0, 2, 3 }, ans);
    }
}
