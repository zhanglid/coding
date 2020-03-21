package com.zhangliang.algorithm;
/*
*/

import java.util.*;

public class MedianTracker {
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();

    public void read(int value) {
        if (minPQ.isEmpty() || value < minPQ.peek()) {
            maxPQ.add(value);
        } else {
            minPQ.add(value);
        }

        // If maxPQ is larger.
        while (maxPQ.size() + 1 > minPQ.size()) {
            minPQ.add(maxPQ.poll());
        }

        // If minPQ is larger.
        while (minPQ.size() > maxPQ.size()) {
            maxPQ.add(minPQ.poll());
        }
    }

    public Double median() {
        if ((minPQ.size() + maxPQ.size()) % 2 == 1) {
            return (double) maxPQ.peek();
        }
        if (minPQ.size() + maxPQ.size() < 2) {
            return null;
        }
        double a = minPQ.peek();
        double b = maxPQ.peek();
        return (a + b) / 2.0;
    }
}
