package com.zhangliang.google;
/*
给了一堆log，log里有用户id，resource id以resource在某个起始时间和终止时间的使用量，比如 用户abc在1到5秒钟使用了CPU
的数量是2，用户abc在2到3秒使用的CPU数量是4，也就是一个 用户对某个resource的使用在某个时间是可以叠加的，​给定一个resource 
id，根据用户对这个 resource的peak使用量，找到top k的用户​。上面的例子中abc的CPU的peak使用量是2+4=6
follow up:如果数据量很大怎么办。
这题就是找根据resource id，找到每个user的这个resource的使用情况，然后根据start，end time 排序，从左到右扫，每个时间段，
开始时间标识+1，结束时间标识-1，记录最大值即可。 每个log按照开始结束分成2段，(int time, int cpu, boolean isStart)，
然后排序，扫描即可。
Follow up: 数据量很大的问题也没有太好的办法，如果时间范围跨总体很小的话，可以用 map-reduce。
*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class UserCPUPeak {
    static class Log {
        String userId;
        String resourceId;
        int startTime;
        int endTime;
        int CPUnum;

        public Log(String userId, String resourceId, int startTime, int endTime, int CPUnum) {
            this.userId = userId;
            this.resourceId = resourceId;
            this.startTime = startTime;
            this.endTime = endTime;
            this.CPUnum = CPUnum;
        }
    }

    class Point {
        int num;
        int time;

        public Point(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public int solve(Log[] logs) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return a.time - b.time;
            }
        });

        for (Log log : logs) {
            pq.add(new Point(log.CPUnum, log.startTime));
            pq.add(new Point(-log.CPUnum, log.endTime));
        }

        int maxNum = 0;
        int curNum = 0;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            curNum += cur.num;
            while (!pq.isEmpty() && pq.peek().time == cur.time) {
                cur = pq.poll();
                curNum += cur.num;
            }
            maxNum = Math.max(curNum, maxNum);
        }

        return maxNum;
    }
}
