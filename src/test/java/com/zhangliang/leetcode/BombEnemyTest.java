package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class BombEnemyTest {

    @Test
    public void testCase() {
        BombEnemy s = new BombEnemy();
        int ans = s.maxKilledEnemies(
                new char[][] { { '0', 'E', '0', '0' }, { 'E', '0', 'W', 'E' }, { '0', 'E', '0', '0' } });
        assertEquals(3, ans);
    }

    @Test
    public void errCase() {
        BombEnemy s = new BombEnemy();
        int ans = s.maxKilledEnemies(new char[][] { { 'E', 'E', 'E' } });
        assertEquals(0, ans);
    }
}
