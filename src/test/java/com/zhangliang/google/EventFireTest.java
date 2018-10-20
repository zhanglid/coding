package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class EventFireTest {

    @Test
    public void testCase() {
        EventFire s = new EventFire(3, 3);
        boolean r1 = s.fire(0);
        boolean r2 = s.fire(1);
        boolean r3 = s.fire(2);
        boolean r4 = s.fire(3);
        boolean r5 = s.fire(10);
        assertEquals(false, r1);
        assertEquals(false, r2);
        assertEquals(true, r3);
        assertEquals(true, r4);
        assertEquals(false, r5);
    }
}
