package com.zhangliang.google;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class findAllExtensionTest {

    @Test
    public void testCase() {
        findAllExtension s = new findAllExtension();
        List<int[]> ans = s.solve("heeeeloooo");
        assertArrayEquals(new int[][]{{1, 4}, {6, 9}}, ans.toArray(new int[0][2]));
    }
}
