package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;

public class ArraysWithStepsOfPowerOfTwoTest {

    @Test
    public void testCase() {
        ArraysWithStepsOfPowerOfTwo s = new ArraysWithStepsOfPowerOfTwo();
        List<List<Integer>> ans = s.listArrays(3);
        assertEquals(ans.toString(), "[[0, 1, 2, 3], [0, 2, 3], [0, 1, 3]]");
    }
}
