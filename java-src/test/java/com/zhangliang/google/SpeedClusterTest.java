package com.zhangliang.google;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class SpeedClusterTest {

    @Test
    public void testCase() {
        SpeedCluster s = new SpeedCluster();
        List<Integer> ans = s.clustersLens(new int[] { 2, 4 });
        assertArrayEquals(new Integer[] { 2 }, ans.toArray(new Integer[0]));
    }

    @Test
    public void testCase2() {
        SpeedCluster s = new SpeedCluster();
        List<Integer> ans = s.clustersLens(new int[] { 2, 4, 3, 1, 5 });
        assertArrayEquals(new Integer[] { 3, 2 }, ans.toArray(new Integer[0]));
    }
}
