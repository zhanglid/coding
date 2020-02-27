package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReconstructItineraryTest {

    @Test
    public void testCase() {
        ReconstructItinerary s = new ReconstructItinerary();
        List<String> ans = s.findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO")));
        assertArrayEquals(new String[] { "JFK", "MUC", "LHR", "SFO", "SJC" }, ans.toArray(new String[0]));
    }

    @Test
    public void testCase2() {
        ReconstructItinerary s = new ReconstructItinerary();
        List<String> ans = s.findItinerary(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO")));
        assertArrayEquals(new String[] { "JFK", "ATL", "JFK", "SFO", "ATL", "SFO" }, ans.toArray(new String[0]));
    }
}
