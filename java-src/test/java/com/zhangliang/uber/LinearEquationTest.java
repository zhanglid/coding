package com.zhangliang.uber;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class LinearEquationTest {

    @Test
    public void testCase() {
        LinearEquation s = new LinearEquation();
        int ans = s.solve("2x - ((x - (3x + 1) + 2) + 3) + 4 = x + y", 1);
        assertEquals(3, ans);
    }
}
