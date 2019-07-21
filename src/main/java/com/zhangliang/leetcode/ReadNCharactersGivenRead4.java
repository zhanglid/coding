package com.zhangliang.leetcode;
/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, 
it returns 3 if there is only 3 characters 
left in the file.

By using the read4 API, implement the function int read(char *buf, int n) 
that reads n characters from the file.

Example 1:

Input: buf = "abc", n = 4
Output: "abc"
Explanation: The actual number of characters read is 3, which is "abc".

Example 2:

Input: buf = "abcde", n = 5 
Output: "abcde"
Note:
The read function will only be called once for each test case.

Example 3:

Input: file = "abcdABCD1234", n = 12
Output: 12
Explanation: After calling your read method, buf should contain 
"abcdABCD1234". We read a total of 12 characters from the file, 
so return 12.
Example 4:

Input: file = "leetcode", n = 5
Output: 5
Explanation: After calling your read method, buf should contain "leetc". 
We read a total of 5 characters from the file, so return 5.

*/

import com.zhangliang.utils.Reader4;

/**
 * The read4 API is defined in the parent class Reader4. int read4(char[] buf);
 */
public class ReadNCharactersGivenRead4 extends Reader4 {
    public ReadNCharactersGivenRead4(char[] chars) {
        super(chars);
    }

    // circle buffer
    private char[] extraBuffer = new char[4];
    private int extraBufferSize;
    private int extraBufferStartIndex;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0 || buf == null) {
            return 0;
        }
        int i = 0;
        // read from last left
        if (extraBufferSize > 0) {
            int j = 0;
            for (; j < extraBufferSize && i + j < n; j++) {
                buf[i + j] = extraBuffer[(extraBufferStartIndex + j) % extraBuffer.length];
            }
            extraBufferSize -= j;
            i += j;
            extraBufferStartIndex += j;
            extraBufferStartIndex %= extraBuffer.length;
        }

        // read from read4
        char[] buf4 = new char[4];
        while (i < n) {
            int num = read4(buf4);
            int j = 0;
            for (; j < num && i + j < n; j++) {
                buf[i + j] = buf4[j];
            }
            if (j < num) {
                extraBufferSize = num - j;
                for (int t = 0; t < extraBufferSize; t++) {
                    extraBuffer[(extraBufferStartIndex + t) % extraBuffer.length] = buf4[j + t];
                }
            }
            i += j;
            if (num < 4) {
                break;
            }
        }

        return i;
    }
}
