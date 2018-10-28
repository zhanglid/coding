package com.zhangliang.google;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class SuccessionThroneTest {

    @Test
    public void testCase() {
        SuccessionThrone s = new SuccessionThrone("P1");
        s.birth("P1", "P2");
        List<String> list = s.getOrderOfSuccession();
        assertArrayEquals(list.toArray(new String[0]), new String[] { "P1", "P2" });
    }

    @Test
    public void testCase2() {
        SuccessionThrone s = new SuccessionThrone("P1");
        s.birth("P1", "P2");
        s.birth("P2", "P3");
        List<String> list = s.getOrderOfSuccession();
        assertArrayEquals(list.toArray(new String[0]), new String[] { "P1", "P2", "P3" });
    }

    @Test
    public void testCase3() {
        SuccessionThrone s = new SuccessionThrone("P1");
        s.birth("P1", "P2");
        s.birth("P2", "P3");
        s.die("P2");
        List<String> list = s.getOrderOfSuccession();
        assertArrayEquals(list.toArray(new String[0]), new String[] { "P1", "P3" });
    }

    @Test
    public void testCase4() {
        SuccessionThrone s = new SuccessionThrone("P1");
        s.birth("P1", "P2");
        s.birth("P1", "P5");
        s.birth("P5", "P6");
        s.birth("P2", "P3");
        s.birth("P2", "P7");
        s.die("P2");
        List<String> list = s.getOrderOfSuccession();
        assertArrayEquals(list.toArray(new String[0]), new String[] { "P1", "P3", "P7", "P5", "P6" });
    }
}
