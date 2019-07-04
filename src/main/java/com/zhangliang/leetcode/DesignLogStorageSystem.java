package com.zhangliang.leetcode;
/*
You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the 
following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded 
decimal numbers.

Design a log storage system to implement the following functions:

void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.


int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the 
range from start to end. Start and end all have the same format as timestamp. However, granularity means the time 
level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day",
 it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.

Example 1:
put(1, "2017:01:01:23:59:59");
put(2, "2017:01:01:22:59:59");
put(3, "2016:01:01:00:00:00");
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs 
within 2016 and 2017.
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs 
start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
Note:
There will be at most 300 operations of Put or Retrieve.
Year ranges from [2000,2017]. Hour ranges from [00,23].
Output for Retrieve has no order required.

*/

import java.util.*;

public class DesignLogStorageSystem {
    public static class LogSystem {
        private static class TimestampCalculator {
            private static Map<String, Integer> graMap;
            private static String[] startDefaultValues = new String[] { "2000", "00", "00", "00", "00", "00" };
            private static String[] endDefaultValues = new String[] { "2017", "12", "31", "23", "59", "59" };
            private Integer index;
            static {
                graMap = new HashMap<>();
                // Year:Month:Day:Hour:Minute:Second
                graMap.put("Year", 0);
                graMap.put("Month", 1);
                graMap.put("Day", 2);
                graMap.put("Hour", 3);
                graMap.put("Minute", 4);
                graMap.put("Second", 5);
            }

            public TimestampCalculator(String gra) {
                this.index = graMap.get(gra);
            }

            private String mask(String s, String[] maskStrings) {
                String[] parts = s.split(":");
                for (int i = index + 1; i < parts.length; i++) {
                    parts[i] = maskStrings[i];
                }
                return String.join(":", parts);
            }

            public String getStart(String s) {
                return mask(s, startDefaultValues);
            }

            public String getEnd(String s) {
                return mask(s, endDefaultValues);
            }
        }

        private TreeMap<String, Integer> tm;

        public LogSystem() {
            tm = new TreeMap<String, Integer>(new Comparator<String>() {
                public int compare(String a, String b) {
                    for (int i = 0; i < a.length(); i++) {
                        int diff = a.charAt(i) - b.charAt(i);
                        if (diff != 0) {
                            return diff;
                        }
                    }
                    return 0;
                }
            });
        }

        public void put(int id, String timestamp) {
            tm.put(timestamp, id);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            TimestampCalculator tc = new TimestampCalculator(gra);
            String end = tc.getEnd(e);
            List<Integer> result = new ArrayList<Integer>(tm.subMap(tc.getStart(s), end).values());
            if (tm.containsKey(end)) {
                result.add(tm.get(end));
            }
            return result;
        }
    }
}
