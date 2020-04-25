package com.zhangliang.utils;

public class Point {
    public int x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    public static Point[] getPointsFromArray(int[][] arr) {
        Point[] points = new Point[arr.length];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(arr[i][0], arr[i][1]);
        }

        return points;
    }
}
