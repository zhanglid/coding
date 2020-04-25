package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InsertDeleteGetrandomO1DuplicatesAllowedTest {

    @Test
    public void testCase() {
        InsertDeleteGetrandomO1DuplicatesAllowed.RandomizedCollection s = new InsertDeleteGetrandomO1DuplicatesAllowed.RandomizedCollection();
        assertEquals(false, s.insert(1));
        assertEquals(true, s.insert(1));
        assertEquals(false, s.insert(2));
        int rand = s.getRandom();
        assertEquals(true, rand == 1 || rand == 2);
        assertEquals(true, s.remove(1));
    }

    @Test
    public void errCase() {
        InsertDeleteGetrandomO1DuplicatesAllowed.RandomizedCollection s = new InsertDeleteGetrandomO1DuplicatesAllowed.RandomizedCollection();
        assertEquals(false, s.insert(1));
        assertEquals(true, s.remove(1));
    }
}
