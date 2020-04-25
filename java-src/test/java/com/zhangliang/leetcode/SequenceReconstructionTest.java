package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SequenceReconstructionTest {

    @Test
    public void testCase() {
        SequenceReconstruction s = new SequenceReconstruction();
        boolean ans = s.sequenceReconstruction(new int[] { 1, 2, 3 },
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3)));
        assertEquals(false, ans);
    }

    @Test
    public void testCase2() {
        SequenceReconstruction s = new SequenceReconstruction();
        boolean ans = s.sequenceReconstruction(new int[] { 1, 2, 3 }, Arrays.asList(Arrays.asList(1, 2)));
        assertEquals(false, ans);
    }

    @Test
    public void testCase3() {
        SequenceReconstruction s = new SequenceReconstruction();
        boolean ans = s.sequenceReconstruction(new int[] { 1, 2, 3 },
                Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3)));
        assertEquals(true, ans);
    }

    @Test
    public void testCase4() {
        SequenceReconstruction s = new SequenceReconstruction();
        boolean ans = s.sequenceReconstruction(new int[] { 4, 1, 5, 2, 6, 3 },
                Arrays.asList(Arrays.asList(5, 2, 6, 3), Arrays.asList(4, 1, 5, 2)));
        assertEquals(true, ans);
    }

    @Test
    public void errCase() {
        SequenceReconstruction s = new SequenceReconstruction();
        boolean ans = s.sequenceReconstruction(new int[] { 1 },
                Arrays.asList(Arrays.asList(1), Arrays.asList(1), Arrays.asList(1)));
        assertEquals(true, ans);
    }
}
