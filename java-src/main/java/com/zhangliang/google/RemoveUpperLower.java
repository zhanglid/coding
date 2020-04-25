package com.zhangliang.google;
/*
Give a string contains lower and upper case. Remove all character if two characters are 
the same character with one upper and one lower

Example 1
s = "AaAaaa"
Output: "aa"

Example 2
s = "Aa"
Output: ""

Follow up:
What if we want to remove it repeatedly?

Example
s = "AAAaaa";
Output: ""

AAAaaa -> AAaa
AAaa -> Aa
Aa -> 0

*/

public class RemoveUpperLower {
    private boolean canRemove(char a, char b) {
        return ((Character.isUpperCase(a) && Character.isLowerCase(b) && ((a - 'A' + 'a') == (int) b))
                || (Character.isUpperCase(b) && Character.isLowerCase(a)) && ((b - 'A' + 'a' == (int) a)));
    }

    public String removeUpperLower(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int i = 0;
        for (; i < chars.length - 1; i++) {
            if (canRemove(chars[i], chars[i + 1])) {
                i++;
            } else {
                chars[l++] = chars[i];
            }
        }
        if (i == chars.length - 1) {
            chars[l++] = chars[i];
        }
        return new String(chars, 0, l);
    }

    // Using stack.
    public String repeatedlyRemoveUpperLower(String s) {
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (sb.length() > 0 && canRemove(sb.charAt(sb.length() - 1), x)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(x);
            }
        }
        return sb.toString();
    }

    private int helper(char[] chars, int size) {
        if (size < 2) {
            return size;
        }
        int restSize = helper(chars, size - 1);
        chars[restSize] = chars[size - 1];
        restSize++;
        while (restSize > 1 && canRemove(chars[restSize - 2], chars[restSize - 1])) {
            return restSize - 2;
        }
        return restSize;
    }

    // Recursion
    public String repeatedlyRemoveUpperLower2(String s) {
        char[] chars = s.toCharArray();
        int restSize = helper(chars, s.length());
        return new String(chars, 0, restSize);
    }
}
