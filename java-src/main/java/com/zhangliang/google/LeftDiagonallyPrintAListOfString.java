package com.zhangliang.google;
/*
    (想象把string排成一个一列), string的长度不一定相等。
    eg
    a   d   g   i
    b   e   h
    c   f

    output
    abdcegfhi
*/

public class LeftDiagonallyPrintAListOfString {
    private void travel(String[] strings, int i, int j, StringBuilder sb) {
        while (i >= 0 && j < strings.length) {
            if (i < strings[j].length()) {
                sb.append(strings[j].charAt(i));
            }
            i--;
            j++;
        }
    }
    public String solve(String[] strings) {
        if (strings == null || strings.length < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int rows = 0;
        for (String s : strings) {
            rows = Math.max(rows, s.length());
        }

        for (int i = 0; i < rows; i++) {
            travel(strings, i, 0, sb);
        }

        for (int i = 1; i < strings.length; i++) {
            travel(strings, rows - 1, i, sb);
        }

        return sb.toString();
    }
}
