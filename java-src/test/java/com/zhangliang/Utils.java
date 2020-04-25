package com.zhangliang;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static <T> String[] getStrsFrom2DList(List<List<T>> list, boolean isSort) {
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).toString();
        }

        if (isSort)
            Arrays.sort(ans);
        return ans;
    }

    public static <T> String[] getStrsFrom2DList(List<List<T>> list) {
        return getStrsFrom2DList(list, true);
    }

    public static <T> String[] getStrsFromList(List<T> list) {
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).toString();
        }

        Arrays.sort(ans);

        return ans;
    }

    public static String[] getStrsFrom2DIntArray(int[][] items) {
        String[] ans = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            ans[i] = Arrays.toString(items[i]);
        }

        Arrays.sort(ans);

        return ans;
    }
}