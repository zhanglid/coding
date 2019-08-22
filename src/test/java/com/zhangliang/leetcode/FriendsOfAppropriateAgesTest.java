package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FriendsOfAppropriateAgesTest {

    @Test
    public void testCase() {
        FriendsOfAppropriateAges s = new FriendsOfAppropriateAges();
        int ans = s.numFriendRequests(new int[] { 16, 16 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        FriendsOfAppropriateAges s = new FriendsOfAppropriateAges();
        int ans = s.numFriendRequests(new int[] { 16, 17, 18 });
        assertEquals(2, ans);
    }

    @Test
    public void testCase3() {
        FriendsOfAppropriateAges s = new FriendsOfAppropriateAges();
        int ans = s.numFriendRequests(new int[] { 20, 30, 100, 110, 120 });
        assertEquals(3, ans);
    }

    @Test
    public void errCase() {
        FriendsOfAppropriateAges s = new FriendsOfAppropriateAges();
        int ans = s.numFriendRequests(new int[] { 101, 56, 69, 48, 30 });
        assertEquals(4, ans);
    }

    @Test
    public void errCase2() {
        FriendsOfAppropriateAges s = new FriendsOfAppropriateAges();
        int ans = s.numFriendRequests(new int[] { 111, 94, 119, 60, 64, 39, 57, 19, 105, 25 });
        assertEquals(17, ans);
    }

    @Test
    public void errCase3() {
        FriendsOfAppropriateAges s = new FriendsOfAppropriateAges();
        int ans = s.numFriendRequests(new int[] { 108, 115, 5, 24, 82 });
        assertEquals(3, ans);
    }
}
