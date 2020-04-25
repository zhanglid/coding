package com.zhangliang.linkedin;
/*
 给一个长 string，所有 char 只会从四个 char 里面选， output 
 出所有长度为 10 的 duplicate substring， 要 ordered，
 时间复杂度 和如何优化

 e.g
    aaaaaaaaaaa
*/

import java.util.*;

public class DuplicatedSubstringWithGivenLength {
    public List<String> getAllDuplicatedSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 9; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() > 10) {
                sb.deleteCharAt(0);
            }
            String key = s.toString();
            if (set.contains(key)) {
                result.add(key);
            } else {
                set.add(key);
            }
        }
        return new ArrayList<>(result);
    }
}
