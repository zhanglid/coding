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
    private int curIndex = 0;

    public int read(char[] buf, int n) {
        if (n < 1) {
            return 0;
        }

        if (cacheSize >= n) {
            cacheSize -= n;
            return 0;
        }

        int count = 0;
        count += cacheSize;
        n -= cacheSize;
        cacheSize = 0;

        while (n > 0 && curIndex + 4 <= buf.length) {
            count += 4;
            curIndex += 4;
            n -= 4;
        }

        if (n > 0 && curIndex < buf.length) {
            int rest = buf.length - curIndex;
            count += rest;
            curIndex = buf.length;
            n -= rest;
        }

        while (n < 0) {
            cacheSize++;
            n++;
            count--;
        }

        return count;
    }
}
