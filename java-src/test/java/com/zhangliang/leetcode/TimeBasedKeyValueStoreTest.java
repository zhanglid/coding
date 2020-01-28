package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TimeBasedKeyValueStoreTest {
    @Test
    public void testCase() {
        TimeBasedKeyValueStore.TimeMap s = new TimeBasedKeyValueStore.TimeMap();
        s.set("foo", "bar", 1);
        assertEquals(s.get("foo", 1), "bar");
        assertEquals(s.get("foo", 3), "bar");
        s.set("foo", "bar2", 4);
        assertEquals(s.get("foo", 4), "bar2");
        assertEquals(s.get("foo", 5), "bar2");
    }

    @Test
    public void testCase2() {
        TimeBasedKeyValueStore.TimeMap s = new TimeBasedKeyValueStore.TimeMap();
        s.set("love", "high", 10);
        s.set("love", "low", 20);
        assertEquals(s.get("love", 5), "");
        assertEquals(s.get("love", 10), "high");
        assertEquals(s.get("love", 15), "high");
        assertEquals(s.get("love", 20), "low");
        assertEquals(s.get("love", 25), "low");
    }
}
