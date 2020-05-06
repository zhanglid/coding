package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TextJustificationTest {

    @Test
    public void testCase() {
        TextJustification s = new TextJustification();
        assertEquals(2, s.numberOfRows("Apple Peach", 5));
    }

    @Test
    public void testCase2() {
        TextJustification s = new TextJustification();
        assertEquals(2, s.numberOfRows("Apple Peach", 6));
    }

    @Test
    public void testCase3() {
        TextJustification s = new TextJustification();
        assertEquals(2, s.numberOfRows("Apple Peach", 7));
    }

    @Test
    public void testCase4() {
        TextJustification s = new TextJustification();
        assertEquals(1, s.numberOfRows("Apple Peach", 11));
    }
}
