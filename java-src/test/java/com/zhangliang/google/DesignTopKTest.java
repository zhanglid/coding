package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DesignTopKTest {

    @Test
    public void testCase() {
        DesignTopK s = new DesignTopK();
        s.add(1);
        s.add(2);
        s.add(2);
        s.add(5);
        s.add(9);
        assertEquals(1, s.findRank(1));
        assertEquals(2, s.findRank(3));
        assertEquals(9, s.findRank(5));
    }

}
