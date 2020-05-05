package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class MinimumSpinningTreeTest {

    @Test
    public void testCase() {
        MinimumSpinningTree s = new MinimumSpinningTree();
        List<int[]> ans = s.solve(5, Arrays.asList(new int[][] { { 0, 1, 1 }, { 0, 2, 7 }, { 1, 2, 5 }, { 1, 3, 4 },
                { 3, 4, 2 }, { 1, 4, 3 }, { 2, 4, 6 }, { 3, 4, 2 } }));
        assertEquals("[[0, 1, 1], [3, 4, 2], [1, 4, 3], [1, 2, 5]]", Arrays.deepToString(ans.toArray(new int[0][3])));
    }
}
