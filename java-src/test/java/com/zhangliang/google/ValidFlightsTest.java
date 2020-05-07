package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.Test;

public class ValidFlightsTest {

    @Test
    public void testCase() {
        ValidFlights s = new ValidFlights();
        Map<String, Set<String>> graph = new HashMap<>();
        graph.put("LAX", new HashSet<>());
        graph.put("SFO", new HashSet<>());
        graph.put("SEA", new HashSet<>());

        graph.get("LAX").add("SFO");
        graph.get("SFO").add("SEA");
        String[] ans = s.validPath(new String[] { "LAX", "SFO", "SEZ" }, graph);
        assertEquals("[LAX, SFO, SEA]", Arrays.toString(ans));
    }
}
