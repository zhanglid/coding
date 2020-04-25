package com.zhangliang.leetcode;
/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z 
where different letters represent different tasks. Tasks could be done without original order. 
Each task could be done in one interval. For each interval, CPU could finish one task or just be 
idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must 
be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/

import java.util.*;

public class TaskScheduler {
    class TaskCategory {
        char id;
        int lastExecutedTime = -1;
        int count;

        public TaskCategory(char id, int count) {
            this.id = id;
            this.count = count;
        }
    }

    private List<TaskCategory> toTaskCategoryList(char[] tasks) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }
        List<TaskCategory> tcList = new ArrayList<>();
        for (Character task : counts.keySet()) {
            tcList.add(new TaskCategory(task, counts.get(task)));
        }
        return tcList;
    }

    public int leastInterval(char[] tasks, int n) {
        List<TaskCategory> tcList = toTaskCategoryList(tasks);
        PriorityQueue<TaskCategory> pq = new PriorityQueue<>(new Comparator<TaskCategory>() {
            public int compare(TaskCategory a, TaskCategory b) {
                return b.count - a.count;
            }
        });
        for (TaskCategory tc : tcList) {
            pq.add(tc);
        }
        LinkedList<TaskCategory> queue = new LinkedList<>();
        int totalTaskCount = tasks.length;
        int time = 0;
        while (totalTaskCount > 0) {
            if (!queue.isEmpty() && queue.peekFirst().lastExecutedTime + n < time) {
                pq.add(queue.pollFirst());
            }
            if (!pq.isEmpty()) {
                TaskCategory tc = pq.poll();
                totalTaskCount--;
                tc.count--;
                tc.lastExecutedTime = time;
                if (tc.count > 0) {
                    queue.add(tc);
                }
            }
            if (pq.isEmpty() && !queue.isEmpty()) {
                time = queue.peekFirst().lastExecutedTime + n;
            }
            time++;
        }
        return time;
    }
}
