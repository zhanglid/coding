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

    @Test
    public void errCase() {
        MissingRanges s = new MissingRanges();
        List<String> ans = s.findMissingRanges(new int[] {}, 1, 1);
        assertArrayEquals(new String[] { "1" }, ans.toArray(new String[0]));
    }

    @Test
    public void errCase2() {
        MissingRanges s = new MissingRanges();
        List<String> ans = s.findMissingRanges(new int[] { 1, 1, 1 }, 1, 1);
        assertArrayEquals(new String[] {}, ans.toArray(new String[0]));
    }

    @Test
    public void errCase3() {
        MissingRanges s = new MissingRanges();
        List<String> ans = s.findMissingRanges(new int[] { 2147483647 }, 0, 2147483647);
        assertArrayEquals(new String[] { "0->2147483646" }, ans.toArray(new String[0]));
    }

    @Test
    public void errCase4() {
        MissingRanges s = new MissingRanges();
        List<String> ans = s.findMissingRanges(new int[] { -2147483648, -2147483648, 0, 2147483647, 2147483647 },
                -2147483648, 2147483647);
        assertArrayEquals(new String[] { "-2147483647->-1", "1->2147483646" }, ans.toArray(new String[0]));
    }
}
