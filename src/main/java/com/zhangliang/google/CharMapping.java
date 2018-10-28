package com.zhangliang.google;
/*
先面了到简单的题，abc -> edf，a map成e，b map成d，c map成f，多个字母可能map到同一个字母，
比如 a ，e 都可以map 成 f 
followup : 在第一步map 完之后 ，比如 a map 成 b 之后 ，原字符 串变成了 bbc , 这时候再把
b map 成d ，就破坏了之前的map ，问怎么办，我说中间加一层 ，把b map 到d 这个过程改成b map 到4 
， 4 再 map 到d ，小哥说ok ，那能不能写一个函数 ，判断我们在map 的过程当中需要 返回是否要加这
中间一层的过程
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CharMapping {
    public boolean canMapping(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                if (map.get(a.charAt(i)) != b.charAt(i)) {
                    return false;
                }
            } else {
                map.put(a.charAt(i), b.charAt(i));
            }
        }
        return true;
    }

    public boolean isAdditionalMappingRequired(String a, String b) {
        if (a == null || b == null || !canMapping(a, b)) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char x : b.toCharArray()) {
            set.add(x);
        }
        return requireAdditionalMappingHelper(a, b, set);
    }

    public boolean isAdditionalMappingRequiredTopo(String a, String b) {
        if (a == null || b == null || !canMapping(a, b)) {
            return false;
        }
        boolean[][] adj = new boolean[26][26];
        for (int i = 0; i < a.length(); i++) {
            adj[b.charAt(i) - 'a'][a.charAt(i) - 'a'] = true;
        }
        Set<Character> visited = new HashSet<>();
        for (char x : (a + b).toCharArray()) {
            if (!visited.contains(x)) {
                Set<Character> nextSet = new HashSet<>();
                if (hasCycle(x, adj, nextSet)) {
                    return true;
                }
                visited.addAll(nextSet);
            }
        }

        return false;
    }

    private boolean hasCycle(char x, boolean[][] adj, Set<Character> visited) {
        if (visited.contains(x)) {
            return true;
        }
        visited.add(x);
        for (char n = 'a'; n <= 'z'; n++) {
            if (adj[x - 'a'][n - 'a']) {
                if (hasCycle(n, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean requireAdditionalMappingHelper(String a, String b, Set<Character> set) {
        if (a.equals(b)) {
            return false;
        }
        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!set.contains(b.charAt(i))) {
                    char old = a.charAt(i);
                    a.replace(a.charAt(i), b.charAt(i));
                    set.add(b.charAt(i));
                    if (!requireAdditionalMappingHelper(a, b, set)) {
                        return false;
                    }
                    a.replace(b.charAt(i), old);
                    set.remove(b.charAt(i));
                }
            }
        }

        return true;
    }

    public List<String> getPath(String a, String b) {
        if (a == null || b == null || !canMapping(a, b)) {
            return null;
        }
    }

    private List<String> getPathHelper(String a, String b, Set<Character> set) {
        List<String> list = new ArrayList<>();
        list.add(a);
        if (a.equals(b)) {
            return new ArrayList<>(list);
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && !set.contains(b.charAt(i))) {
                char old = a.charAt(i);
                a.replace(old, b.charAt(i));
                set.add(b.charAt(i));
                List<String> result = getPathHelper(a, b, set);
                if (result != null) {
                    return result;
                }
                list.remove(list.size() - 1);
                set.remove(b.charAt(i));
            }
        }
    }
}
