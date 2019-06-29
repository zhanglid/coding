package com.zhangliang.leetcode;
/*
Given a start IP address ip and a number of ips we need to cover n, return a 
representation of the range as a list (of smallest possible length) of CIDR blocks.

A CIDR block is a string consisting of an IP, followed by a slash, and then the 
prefix length. For example: "123.45.67.89/20". That prefix length "20" represents 
the number of common prefix bits in the specified range.

Example 1:
Input: ip = "255.0.0.7", n = 10
Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
Explanation:
The initial ip address, when converted to binary, looks like this (spaces added for 
clarity):
255.0.0.7 -> 11111111 00000000 00000000 00000111
The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits 
to the given address,
ie. just this one address.

The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits 
to the given address:
255.0.0.8 -> 11111111 00000000 00000000 00001000
Addresses with common prefix of 29 bits are:
11111111 00000000 00000000 00001000
11111111 00000000 00000000 00001001
11111111 00000000 00000000 00001010
11111111 00000000 00000000 00001011
11111111 00000000 00000000 00001100
11111111 00000000 00000000 00001101
11111111 00000000 00000000 00001110
11111111 00000000 00000000 00001111

The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits 
to the given address,
ie. just 11111111 00000000 00000000 00010000.

In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7

There were other representations, such as:
["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
but our answer was the shortest possible.

Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100 
that are outside the specified range.

Note:
ip will be a valid IPv4 address.
Every implied address ip + x (for x < n) will be a valid IPv4 address.
n will be an integer in the range [1, 1000].

*/

import java.util.*;

public class IpToCidr {
    static class IpBase {
        public static char[] parseToParts(String ip) {
            char[] parsed = new char[4];
            String[] parts = ip.split("\\.");

            for (int i = 0; i < parts.length; i++) {
                parsed[i] = (char) Integer.parseInt(parts[i]);
            }
            return parsed;
        }

        public static int getInt(char[] parts) {
            int base = 1;
            int ans = 0;
            for (int i = parts.length - 1; i >= 0; i--) {
                ans += parts[i] * base;
                base = base << 8;
            }
            return ans;
        }

        public static int parseInt(String ip) {
            return getInt(parseToParts(ip));
        }

        public static String intToIp(int val) {
            int base = (1 << 8) - 1;
            int bitsShifted = 0;
            String[] parts = new String[4];
            for (int i = 3; i >= 0; i--) {
                parts[i] = Integer.toString((val & base) >>> bitsShifted);
                base = base << 8;
                bitsShifted += 8;
            }
            return String.join(".", parts);
        }

        private int ipVal;

        public IpBase(String ip) {
            ipVal = parseInt(ip);
        }

        public int getMaxNums() {
            return (ipVal & -ipVal);
        }

        public void add(int val) {
            ipVal += val;
        }

        public String getIp() {
            return intToIp(ipVal);
        }
    }

    public static int log2(int num) {
        int ans = 0;
        int base = 1;
        while (base <= num) {
            ans += 1;
            base = base << 1;
        }
        return ans - 1;
    }

    public List<String> ipToCIDR(String ip, int n) {
        IpBase ipBase = new IpBase(ip);
        List<String> ans = new ArrayList<>();
        while (n > 0) {
            int maxNum = ipBase.getMaxNums();
            int num = 1;
            while (num <= n && num <= maxNum) {
                num = num << 1;
            }
            num = num >> 1;
            ans.add(ipBase.getIp() + "/" + (32 - log2(num)));
            ipBase.add(num);
            n -= num;
        }
        return ans;
    }
}
