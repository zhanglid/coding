package com.zhangliang.google;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindStringMatchingFromStreamTest {

    @Test
    public void testCase() {
        FindStringMatchingFromStream s = new FindStringMatchingFromStream();
        List<String> ans = s.solve(new String[] { "abc", "att", "bba", "bc", "abce" }, "tabcet");
        assertArrayEquals(new String[] { "abc", "bc", "abce" }, ans.toArray(new String[0]));
    }
}
