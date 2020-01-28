package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class BrickWallTest {
    private List<List<Integer>> toList(int[][] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < nums[i].length; j++) {
                ans.get(i).add(nums[i][j]);
            }
        }
        return ans;
    }

    @Test
    public void testCase() {
        BrickWall s = new BrickWall();
        int ans = s.leastBricks(toList(
                new int[][] { { 1, 2, 2, 1 }, { 3, 1, 2 }, { 1, 3, 2 }, { 2, 4 }, { 3, 1, 2 }, { 1, 3, 1, 1 } }));
        assertEquals(2, ans);
    }
}
