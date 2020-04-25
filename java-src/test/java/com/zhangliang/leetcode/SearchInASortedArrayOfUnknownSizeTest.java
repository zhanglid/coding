package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.ArrayReader;

import org.junit.Test;

public class SearchInASortedArrayOfUnknownSizeTest {

    @Test
    public void testCase() {
        SearchInASortedArrayOfUnknownSize s = new SearchInASortedArrayOfUnknownSize();
        int ans = s.search(new ArrayReader(new int[] { -1, 0, 3, 5, 9, 12 }), 9);
        assertEquals(4, ans);
    }

    @Test
    public void testCase2() {
        SearchInASortedArrayOfUnknownSize s = new SearchInASortedArrayOfUnknownSize();
        int ans = s.search(new ArrayReader(new int[] { -1, 0, 3, 5, 9, 12 }), 2);
        assertEquals(-1, ans);
    }
}
