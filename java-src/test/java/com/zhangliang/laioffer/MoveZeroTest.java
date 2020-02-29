package com.zhangliang.laioffer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MoveZeroTest {

    @Test
    public void testCase() {
        MoveZero s = new MoveZero();
        int[] nums = new int[] { 0, 1, 3, 4, 0, 4, 3, 7 };
        s.moveZero(nums);
        assertArrayEquals(new int[] { 1, 3, 4, 4, 3, 7, 0, 0 }, nums);
    }
}
