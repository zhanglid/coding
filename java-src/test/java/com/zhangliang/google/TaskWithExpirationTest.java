package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TaskWithExpirationTest {

    @Test
    public void testCase() {
        TaskWithExpiration s = new TaskWithExpiration(10);
        s.put(1, 101, 0);
        assertEquals(101, s.get(1, 0));
        assertEquals(-1, s.get(1, 10));
    }
}
