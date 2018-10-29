package com.zhangliang.google;
/*
Return any binary tree that matches the given preorder and postorder 
traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 

Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, 
you can return any of them.
*/

import java.util.HashMap;
import java.util.Map;

public class NumOfTreesFromPreorderAndPostorder {
    public int NumsOfTreeFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }

        return getNum(pre, post, 0, 0, post.length, map);
    }

    private int getNum(int[] pre, int[] post, int s1, int s2, int len, Map<Integer, Integer> indexMap) {
        if (len <= 1) {
            return 1;
        }
        int index = indexMap.get(pre[s1 + 1]);
        int leftLen = index - s2 + 1;
        int rightLen = len - leftLen - 1;
        int leftNum = getNum(pre, post, s1 + 1, s2, leftLen, indexMap);
        if (rightLen == 0) {
            return 2 * leftNum;
        }
        int rightNum = getNum(pre, post, s1 + leftLen + 1, s2 + leftLen, rightLen, indexMap);

        return leftNum * rightNum;
    }
}
