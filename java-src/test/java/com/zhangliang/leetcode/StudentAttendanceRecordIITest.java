package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StudentAttendanceRecordIITest {

    @Test
    public void testCase() {
        StudentAttendanceRecordII s = new StudentAttendanceRecordII();
        int ans = s.checkRecord(2);
        assertEquals(8, ans);
    }

    @Test
    public void errCase() {
        StudentAttendanceRecordII s = new StudentAttendanceRecordII();
        int ans = s.checkRecord(3);
        assertEquals(19, ans);
    }

    @Test
    public void errCase2() {
        StudentAttendanceRecordII s = new StudentAttendanceRecordII();
        int ans = s.checkRecord(100);
        assertEquals(985598218, ans);
    }
}
