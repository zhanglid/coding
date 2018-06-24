package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.zhangliang.Utils;
import java.util.List;

import org.junit.Test;

public class PalindromePartitioningTest {

    @Test
    public void testCase() {
        PalindromePartitioning s = new PalindromePartitioning();
        List<List<String>> ans = s.partition("aab");
        assertArrayEquals(new String[] { "[a, a, b]", "[aa, b]" }, Utils.getStrsFrom2DList(ans));
    }
}
