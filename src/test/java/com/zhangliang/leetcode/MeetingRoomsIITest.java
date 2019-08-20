package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MeetingRoomsIITest {

    @Test
    public void testCase() {
        MeetingRoomsII s = new MeetingRoomsII();
        int ans = s.minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        MeetingRoomsII s = new MeetingRoomsII();
        int ans = s.minMeetingRooms(new int[][] { { 7, 10 }, { 2, 4 } });
        assertEquals(1, ans);
    }
}
