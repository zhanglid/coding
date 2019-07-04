package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class DesignLogStorageSystemTest {

    private void assertCorrect(int[] expected, List<Integer> ans) {
        Integer[] expectedIntegers = new Integer[expected.length];
        for (int i = 0; i < expected.length; i++) {
            expectedIntegers[i] = expected[i];
        }
        Collections.sort(ans);
        Arrays.sort(expected);
        assertArrayEquals(expectedIntegers, ans.toArray(new Integer[0]));
    }

    @Test
    public void testCase() {
        DesignLogStorageSystem.LogSystem s = new DesignLogStorageSystem.LogSystem();
        s.put(1, "2017:01:01:23:59:59");
        s.put(2, "2017:01:01:22:59:59");
        s.put(3, "2016:01:01:00:00:00");
        List<Integer> result = s.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
        assertCorrect(new int[] { 1, 2, 3 }, result);
    }

    @Test
    public void testCase2() {
        DesignLogStorageSystem.LogSystem s = new DesignLogStorageSystem.LogSystem();
        s.put(1, "2017:01:01:23:59:59");
        s.put(2, "2017:01:01:22:59:59");
        s.put(3, "2016:01:01:00:00:00");
        List<Integer> result = s.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
        assertCorrect(new int[] { 1, 2 }, result);
    }
}
