package com.zhangliang.leetcode;
/*
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being 
made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that 
the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:

HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 

Follow up:
What if the number of hits per second could be very large? Does your design scale? 
- No. We have to use LinkedHashmap
*/

import java.util.*;

public class DesignHitCounter {
    static class HitCounter {
        private LinkedHashMap<Integer, Integer> hitGroups = new LinkedHashMap<>();
        private int lastTimestamp = 1;
        private int count = 0;

        /** Initialize your data structure here. */
        public HitCounter() {

        }

        /**
         * Record a hit.
         * 
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            hitGroups.put(timestamp, hitGroups.getOrDefault(timestamp, 0) + 1);
            count++;
        }

        /**
         * Return the number of hits in the past 5 minutes.
         * 
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            for (int i = lastTimestamp; i <= timestamp - 300; i++) {
                if (hitGroups.containsKey(i)) {
                    count -= hitGroups.get(i);
                }
                hitGroups.remove(i);
            }
            return count;
        }
    }
}
