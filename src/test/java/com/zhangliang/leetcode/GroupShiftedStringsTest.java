package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import com.zhangliang.Utils;

import org.junit.Test;

public class GroupShiftedStringsTest {

    @Test
    public void testCase() {
        GroupShiftedStrings s = new GroupShiftedStrings();
        List<List<String>> ans = s.groupStrings(new String[]{ "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" });
        String[] expected = new String[]{ "[abc, bcd, xyz]", "[az, ba]", "[acef]", "[a, z]" };
        String[] ansStrs = Utils.getStrsFrom2DList(ans);
        Arrays.sort(expected);
        Arrays.sort(ansStrs);
        assertArrayEquals(expected, ansStrs);
    }
}
