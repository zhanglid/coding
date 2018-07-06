package com.zhangliang.leetcode;
/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters 
left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Example 1:

Input: buf = "abc", n = 4
Output: "abc"
Explanation: The actual number of characters read is 3, which is "abc".
Example 2:

Input: buf = "abcde", n = 5 
Output: "abcde"
Note:
The read function will only be called once for each test case.
*/

public class ReadNCharactersGivenRead4 {
    private int offset = 0;

    private int read4(char[] buf) {
        int nextOffset = Math.min(offset + 4, buf.length);
        int diff = nextOffset - offset;
        offset = nextOffset;
        return diff;
    }

    private int cacheSize = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || n < 1) {
            return 0;
        }
        char[] buffer = new char[4];
        int count = cacheSize;
        int i = 0;
        while (count < n) {
            int num = read4(buffer);
            count += num;
            for (int j = 0; i < count && j < num; j++) {
                buf[i++] = buffer[j];
            }
            if (num < 4) {
                break;
            }
        }

        if (count > n) {
            cacheSize = count - n;
        } else {
            cacheSize = 0;
        }
        return Math.min(n, count);
    }
}
