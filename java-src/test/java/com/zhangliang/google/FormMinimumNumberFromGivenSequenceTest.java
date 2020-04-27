package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FormMinimumNumberFromGivenSequenceTest {

    @Test
    public void testCase() {
        FormMinimumNumberFromGivenSequence s = new FormMinimumNumberFromGivenSequence();
        int ans = s.getNum("DDIDDIID");
        assertEquals(321654798, ans);
    }

    @Test
    public void testCase2() {
        FormMinimumNumberFromGivenSequence s = new FormMinimumNumberFromGivenSequence();
        int ans = s.getNum("IIDDD");
        assertEquals(126543, ans);
    }

    @Test
    public void testCase3() {
        FormMinimumNumberFromGivenSequence s = new FormMinimumNumberFromGivenSequence();
        int ans = s.getNum("DIDI");
        assertEquals(21435, ans);
    }

    @Test
    public void testCase4() {
        FormMinimumNumberFromGivenSequence s = new FormMinimumNumberFromGivenSequence();
        int ans = s.getNum("II");
        assertEquals(123, ans);
    }

    @Test
    public void testCase5() {
        FormMinimumNumberFromGivenSequence s = new FormMinimumNumberFromGivenSequence();
        int ans = s.getNum("DD");
        assertEquals(321, ans);
    }

    @Test
    public void testCase6() {
        FormMinimumNumberFromGivenSequence s = new FormMinimumNumberFromGivenSequence();
        int ans = s.getNum("I");
        assertEquals(12, ans);
    }

    @Test
    public void testCase7() {
        FormMinimumNumberFromGivenSequence s = new FormMinimumNumberFromGivenSequence();
        int ans = s.getNum("D");
        assertEquals(21, ans);
    }
}
