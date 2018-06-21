package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class MissingRangesTest {

    @Test
    public void testCase() {
        MissingRanges s = new MissingRanges();
        List<String> ans = s.findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99);
        assertArrayEquals(new String[] { "2", "4->49", "51->74", "76->99" }, ans.toArray(new String[0]));
    }
}
