package com.zhangliang.leetcode;
/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' 
together, 
such as "/home//oo/".
In this case, you should ignore redundant slashes and return "/home/foo".

*/

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        LinkedList<String> result = new LinkedList<>();
        for (String part : parts) {
            if (part.equals("")) {
                continue;
            } else if (part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!path.isEmpty()) {
                    result.pollLast();
                }
            } else {
                result.add(part);
            }
        }
        return "/" + String.join("/", result);
    }
}
