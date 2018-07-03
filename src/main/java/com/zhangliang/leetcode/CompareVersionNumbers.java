package com.zhangliang.leetcode;
/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
*/

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.isEmpty() || version2.isEmpty()) {
            return -1;
        }

        int cur1 = 0;
        int cur2 = 0;

        while (cur1 < version1.length() && cur2 < version2.length()) {
            int end1 = cur1;
            while (end1 < version1.length() && version1.charAt(end1) != '.') {
                end1++;
            }
            int part1 = Integer.parseInt(version1.substring(cur1, end1));

            int end2 = cur2;
            while (end2 < version2.length() && version2.charAt(end2) != '.') {
                end2++;
            }
            int part2 = Integer.parseInt(version2.substring(cur2, end2));

            if (part1 < part2) {
                return -1;
            } else if (part1 > part2) {
                return 1;
            }

            cur1 = end1 + 1;
            cur2 = end2 + 1;
        }

        if (cur1 < version1.length()) {
            return 1;
        }

        if (cur2 < version2.length()) {
            return -1;
        }

        return 0;
    }
}
