package com.zhangliang.amazon;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;

public class NearestKRestruantsTest {

    @Test
    public void testCase() {
        NearestKRestruants s = new NearestKRestruants();
        List<Integer> ans = s.nearestKRestruants(new int[][] { { 1, 1 }, { 2, 2 }, { 1, 0 }, { 0, 1 } }, 2);
        assertEquals("[2, 3]", ans.toString());
    }
}
