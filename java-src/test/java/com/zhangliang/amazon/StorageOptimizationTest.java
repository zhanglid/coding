package com.zhangliang.amazon;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class StorageOptimizationTest {

    @Test
    public void testCase() {
        StorageOptimization s = new StorageOptimization();
        int ans = s.solve(2, 2, Arrays.asList(1), Arrays.asList(2));
        assertEquals(4, ans);
        ;
    }
}
