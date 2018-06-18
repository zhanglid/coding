package com.zhangliang.leetcode;
/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters 
left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.

Example 1: 

Given buf = "abc"
read("abc", 1) // returns "a"
read("abc", 2); // returns "bc"
read("abc", 1); // returns ""
Example 2: 

Given buf = "abc"
read("abc", 4) // returns "abc"
read("abc", 1); // returns ""
*/

public class ReadNCharactersGivenRead4II {
    private int cacheSize = 0;
    private int cacheIndex = 0;
    private int curIndex = 0;
    private char[] cache = new char[4];
    private char[] buf;

    public ReadNCharactersGivenRead4II(char[] buf) {
        this.buf = buf;
    }

    private int read4(char[] buf) {
        int count = Math.min(4, this.buf.length - curIndex);

        for (int i = curIndex; i < curIndex + count; i++) {
            buf[i - curIndex] = this.buf[curIndex];
        }
        curIndex += count;
        return count;
    }

    public int read(char[] buf, int n) {
        if (n < 1) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < Math.min(cacheSize, n); i++) {
            buf[index++] = cache[cacheIndex++];
            cacheIndex %= cache.length;
        }
        cacheSize -= index;
        n -= index;

        while (n > 0) {
            char[] buf4 = new char[4];
            int realReadNum = read4(buf4);
            if (realReadNum < 1) {
                break;
            }
            int buf4index = 0;
            while (n > 0 && realReadNum > 0) {
                buf[index++] = buf4[buf4index++];
                realReadNum--;
                n--;
            }

            int cacheWriteIndex = cacheIndex;
            while (realReadNum > 0) {
                cache[cacheWriteIndex++] = buf4[buf4index++];
                realReadNum--;
                cacheWriteIndex = cacheWriteIndex % cache.length;
                cacheSize++;
            }
        }

        return index;
    }
}
