package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BallFallingTest {

    @Test
    public void testCase() {
        char[][] board = new char[][] { { '/', '/', '\\', '\\' }, { '\\', '\\', '/', '/' }, { '/', '/', '\\', '\\' },
                { '\\', '\\', '/', '/' }, };
        BallFalling s = new BallFalling(board);
        assertEquals(-1, s.get(0));
        assertEquals(2, s.get(2));
    }
}
