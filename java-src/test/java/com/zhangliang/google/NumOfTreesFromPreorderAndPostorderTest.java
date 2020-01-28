package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class NumOfTreesFromPreorderAndPostorderTest {

    @Test
    public void testCase() {
        NumOfTreesFromPreorderAndPostorder s = new NumOfTreesFromPreorderAndPostorder();
        int ans = s.NumsOfTreeFromPrePost(new int[] { 1, 2 }, new int[] { 2, 1 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        NumOfTreesFromPreorderAndPostorder s = new NumOfTreesFromPreorderAndPostorder();
        int ans = s.NumsOfTreeFromPrePost(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 });
        assertEquals(4, ans);
    }

    @Test
    public void testCase3() {
        NumOfTreesFromPreorderAndPostorder s = new NumOfTreesFromPreorderAndPostorder();
        int ans = s.NumsOfTreeFromPrePost(new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 });
        assertEquals(1, ans);
    }
}
