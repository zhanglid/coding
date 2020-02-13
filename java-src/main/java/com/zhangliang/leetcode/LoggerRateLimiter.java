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

import java.util.*;

public class LoggerRateLimiter {
    static class Logger {
        class Message {
            int time;
            String message;

            public Message(int time, String message) {
                this.time = time;
                this.message = message;
            }
        }

        Queue<Message> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        /** Initialize your data structure here. */
        public Logger() {

        }

        /**
         * Returns true if the message should be printed in the given timestamp,
         * otherwise returns false. If this method returns false, the message will not
         * be printed. The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            while (!queue.isEmpty() && queue.peek().time <= timestamp - 10) {
                set.remove(queue.poll().message);
            }
            if (set.contains(message)) {
                return false;
            }
            queue.add(new Message(timestamp, message));
            set.add(message);
            return true;
        }
    }

}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
