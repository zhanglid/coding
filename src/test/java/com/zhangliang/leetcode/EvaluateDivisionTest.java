package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class EvaluateDivisionTest {
    private void assertCorrect(double[] expected, double[] ans) {
        assertEquals(expected.length, ans.length);
        for (int i = 0; i < ans.length; i++) {
            assertEquals(expected[i], ans[i], Double.MIN_NORMAL);
        }
    }

    @Test
    public void testCase() {
        EvaluateDivision s = new EvaluateDivision();
        double[] ans = s.calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
                new double[] { 2, 3 }, Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"),
                        Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")

                ));
        assertCorrect(new double[] { 6.0, 0.5, -1.0, 1.0, -1.0 }, ans);
    }
}
