package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.google.DoubleMapWithEplision.DoubleMap;

import org.junit.Test;

public class DoubleMapWithEplisionTest {

    @Test
    public void testCase() {
        DoubleMap<String> s = new DoubleMap<>(0.1);
        s.put(0.1, "FIRST");
        assertEquals("FIRST", s.get(0.15));
    }

    @Test
    public void testCase2() {
        DoubleMap<String> s = new DoubleMap<>(0.1);
        s.put(0.1, "FIRST");
        s.put(0.2, "FIRST");
        assertEquals("FIRST", s.get(0.197));
    }

}
