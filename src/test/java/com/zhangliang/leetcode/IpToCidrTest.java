package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class IpToCidrTest {

    private void assertCorrect(String[] expected, List<String> ans) {
        Arrays.sort(expected);
        Collections.sort(ans);
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void testCase() {
        IpToCidr s = new IpToCidr();
        List<String> ans = s.ipToCIDR("255.0.0.7", 10);
        assertCorrect(new String[] { "255.0.0.7/32", "255.0.0.8/29", "255.0.0.16/32" }, ans);
    }
}
