package com.zhangliang.snapchat;

import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.Test;

public class AllPossibleCalculationResultTest {
    private void assertCorrect(int[] expected, List<Integer> result) {
        Arrays.sort(expected);
        Collections.sort(result);
        assertEquals(Arrays.toString(expected), result.toString());
    }

    @Test
    public void testCase() {
        AllPossibleCalculationResult s = new AllPossibleCalculationResult();
        List<Integer> ans = s.getAllResults("1+2*3-4");
        assertCorrect(new int[] { 5, -1, 3, -3 }, ans);
    }
}
