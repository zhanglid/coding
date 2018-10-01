package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class PredictTheWinnerTest {

    @Test
    public void testCase() {
        PredictTheWinner s = new PredictTheWinner();
        boolean ans = s.PredictTheWinner(new int[] { 1, 5, 2 });
        assertEquals(false, ans);
    }

    @Test
    public void testCase2() {
        PredictTheWinner s = new PredictTheWinner();
        boolean ans = s.PredictTheWinner(new int[] { 1, 5, 233, 7 });
        assertEquals(true, ans);
    }

    @Test
    public void errCase() {
        PredictTheWinner s = new PredictTheWinner();
        boolean ans = s.PredictTheWinner(new int[] {0});
        assertEquals(true, ans);
    }
}
