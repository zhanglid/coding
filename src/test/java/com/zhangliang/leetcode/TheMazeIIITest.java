package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TheMazeIIITest {

    @Test
    public void testCase() {
        TheMazeIII s = new TheMazeIII();
        String ans = s.findShortestWay(
            new int[][] {
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0 }
            },
            new int[]{4, 3},
            new int[]{0, 1}
        );
        assertEquals("lul", ans);
    }

    @Test
    public void testCase2() {
        TheMazeIII s = new TheMazeIII();
        String ans = s.findShortestWay(
            new int[][] {
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0 }
            },
            new int[]{4, 3},
            new int[]{3, 0}
        );
        assertEquals("impossible", ans);
    }

    @Test
    public void errCase() {
        TheMazeIII s = new TheMazeIII();
        String ans = s.findShortestWay(
            new int[][] { 
                { 0,0,1,0,0 },
                { 0,0,0,0,0 },
                { 0,0,0,1,0 },
                { 1,1,0,1,1 },
                { 0,0,0,0,0 } 
            },
            new int[]{0, 4},
            new int[]{4, 4}
        );
        assertEquals("ldldrdr", ans);
    }
    @Test
    public void errCase2() {
        TheMazeIII s = new TheMazeIII();
        String ans = s.findShortestWay(
            new int[][] { 
                    { 0,1,0,0,1,0,0,1,0,0 },
                    { 0,0,1,0,0,1,0,0,1,0 },
                    { 0,0,0,0,0,0,1,0,0,1 },
                    { 0,0,0,0,0,0,1,0,0,1 },
                    { 0,1,0,0,1,0,0,1,0,0 },
                    { 0,0,1,0,0,1,0,0,0,0 },
                    { 0,0,0,0,0,0,1,0,0,0 },
                    { 1,0,0,1,0,0,0,0,0,1 },
                    { 0,1,0,0,1,0,0,1,0,0 },
                    { 0,0,0,0,0,1,0,0,1,0 }
            },
            new int[]{2, 4},
            new int[]{7, 6}
        );
        assertEquals("drdrdrdldl", ans);
    }
}
