package com.zhangliang.leetcode;
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:
Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method 
signature.
*/

import java.util.*;

public class MeetingRoomsII {
    class Event {
        int time;
        boolean isStart;

        public Event(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Event> pq = new PriorityQueue<>(new Comparator<Event>() {
            public int compare(Event a, Event b) {
                int timeDiff = a.time - b.time;
                if (timeDiff != 0) {
                    return timeDiff;
                }
                return a.isStart ? 1 : -1;
            }
        });

        for (int[] interval : intervals) {
            pq.add(new Event(interval[0], true));
            pq.add(new Event(interval[1], false));
        }

        int ans = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Event e = pq.peek();
            while (!pq.isEmpty() && pq.peek().time == e.time) {
                e = pq.poll();
                if (e.isStart) {
                    count++;
                } else {
                    count--;
                }
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
