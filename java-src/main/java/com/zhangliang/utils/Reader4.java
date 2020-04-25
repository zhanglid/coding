package com.zhangliang.utils;

public class Reader4 {
    private char[] buffer;
    private int readCount = 0;

    public Reader4(char[] chars) {
        buffer = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            buffer[i] = chars[i];
        }
    }

    public int read4(char[] buf) {
        if (readCount >= buffer.length) {
            return 0;
        }
        int i = 0;
        for (; i < Math.min(4, buffer.length - readCount); i++) {
            buf[i] = buffer[i + readCount];
        }
        readCount += i;
        return i;
    }
}
