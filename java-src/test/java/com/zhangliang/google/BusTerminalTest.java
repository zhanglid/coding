package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import com.zhangliang.google.BusTerminal.Terminal;
import com.zhangliang.google.BusTerminal.Bus;
import org.junit.Test;

public class BusTerminalTest {
    @Test
    public void testCase() {
        Terminal termial = new Terminal();
        termial.add(new Bus(1, "company 1", 1));
        termial.add(new Bus(2, "company 1", 2));
        termial.add(new Bus(3, "company 1", 3));
        termial.add(new Bus(4, "company 2", 2));
        assertEquals(1, termial.getNext().id);
    }

    @Test
    public void testCase2() {
        Terminal termial = new Terminal();
        termial.add(new Bus(1, "company 1", 1));
        termial.add(new Bus(2, "company 1", 2));
        termial.add(new Bus(3, "company 1", 3));
        termial.add(new Bus(4, "company 2", 2));
        termial.removeAll("company 1");
        assertEquals(4, termial.getNext().id);
    }
}
