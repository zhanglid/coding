package com.zhangliang.leetcode;
/*
Design a logger system that receive stream of messages along with its timestamps, 
each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message 
should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

Example:

Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true; 

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LoggerRateLimiter {
    class TimedMessage {
        public int time;
        public String msg;

        public TimedMessage(int time, String msg) {
            this.time = time;
            this.msg = msg;
        }
    }

    Queue<TimedMessage> queue;
    Set<String> cachedSet = new HashSet<>();
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        queue = new LinkedList<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!queue.isEmpty() && queue.peek().time <= timestamp - 10) {
            cachedSet.remove(queue.poll().msg);
        }
        boolean ans = !cachedSet.contains(message);
        queue.add(new TimedMessage(timestamp, message));
        cachedSet.add(message);
        return ans;
    }
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
