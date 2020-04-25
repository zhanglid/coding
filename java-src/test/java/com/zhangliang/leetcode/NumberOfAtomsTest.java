package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfAtomsTest {

    @Test
    public void testCase() {
        NumberOfAtoms s = new NumberOfAtoms();
        String ans = s.countOfAtoms("H2O");
        assertEquals("H2O", ans);
    }

    @Test
    public void testCase2() {
        NumberOfAtoms s = new NumberOfAtoms();
        String ans = s.countOfAtoms("Mg(OH)2");
        assertEquals("H2MgO2", ans);
    }

    @Test
    public void testCase3() {
        NumberOfAtoms s = new NumberOfAtoms();
        String ans = s.countOfAtoms("K4(ON(SO3)2)2");
        assertEquals("K4N2O14S4", ans);
    }
}
