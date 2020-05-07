package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.Test;

public class ToyMatchingTest {

    @Test
    public void testCase() {
        ToyMatching s = new ToyMatching();
        Map<Integer, Integer> ans = s.solve(new int[][] { { 0, 1, 1 }, { 1, 2, 1 }, { 2, 2, 2 }, { 3, 2, 1 } });
        assertEquals(2, (int) ans.get(0));
    }
}
