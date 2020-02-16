package com.zhangliang.leetcode;
/*
Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. 
For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count 
(if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:
Input: 
formula = "H2O"
Output: "H2O"
Explanation: 
The count of elements are {'H': 2, 'O': 1}.

Example 2:
Input: 
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: 
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

Example 3:
Input: 
formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: 
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

Note:

All atom names consist of lowercase letters, except for the first character which is uppercase.
The length of formula will be in the range [1, 1000].
formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.
*/

import java.util.*;

public class NumberOfAtoms {
    class Result {
        int endIndex;
        Map<String, Integer> elements;

        public Result(int endIndex, Map<String, Integer> elements) {
            this.endIndex = endIndex;
            this.elements = elements;
        }
    }

    private void merge(Map<String, Integer> dest, Map<String, Integer> source, int time) {
        for (String key : source.keySet()) {
            dest.put(key, dest.getOrDefault(key, 0) + source.get(key) * time);
        }
    }

    private Result decode(String s, int startIndex) {
        Result r = new Result(0, new HashMap<>());
        for (int i = startIndex; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') { // end
                r.endIndex = i;
                return r;
            } else if (ch == '(') { // new part
                Result partResult = decode(s, i + 1);
                i = partResult.endIndex + 1;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int count = Integer.parseInt(s.substring(i, j));
                merge(r.elements, partResult.elements, count);
                i = j - 1;
            } else { // one element
                int j = i + 1;
                while (j < s.length() && Character.isLowerCase(s.charAt(j))) {
                    j++;
                }
                String name = s.substring(i, j);
                int nj = j;
                while (nj < s.length() && Character.isDigit(s.charAt(nj))) {
                    nj++;
                }
                int count = nj == j ? 1 : Integer.parseInt(s.substring(j, nj));
                r.elements.put(name, r.elements.getOrDefault(name, 0) + count);
                i = nj - 1;
            }
        }
        return r;
    }

    public String countOfAtoms(String formula) {
        Map<String, Integer> counts = decode(formula, 0).elements;
        List<String> keys = new ArrayList<>(counts.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            if (counts.get(key) > 1) {
                sb.append(counts.get(key));
            }
        }
        return sb.toString();
    }
}
