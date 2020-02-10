package com.zhangliang.leetcode;
/*
Sometimes people repeat letters to represent extra feeling, such as 
"hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", 
we have groups of adjacent letters that are all the same:  "h", "eee", "ll", 
"ooo".

For some given string S, a query word is stretchy if it can be made to be equal 
to S by any number of applications of the following extension operation: choose 
a group consisting of characters c, and add some number of characters c to the 
group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to 
get "hellooo", but we cannot get "helloo" since the group "oo" has size less 
than 3.  Also, we could do another extension like "ll" -> "lllll" to get 
"helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy 
because of these two extension operations: 
query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 
 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or 
more.
 

Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters

*/

import java.util.*;

public class ExpressiveWords {
    class Token {
        char x;
        int num;

        public Token(char x, int num) {
            this.x = x;
            this.num = num;
        }
    }

    private List<Token> tokenize(String S) {
        List<Token> tokenList = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            int j = i + 1;
            while (j < S.length() && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            tokenList.add(new Token(S.charAt(i), j - i));
            i = j - 1;
        }
        return tokenList;
    }

    private boolean isTokenMatch(Token target, Token query) {
        return target.x == query.x && (target.num == query.num || target.num >= 3 && target.num > query.num);
    }

    private boolean checkTokenListMatch(List<Token> targetList, List<Token> queryList) {
        if (targetList.size() != queryList.size()) {
            return false;
        }
        for (int i = 0; i < targetList.size(); i++) {
            Token target = targetList.get(i);
            Token query = queryList.get(i);
            if (!isTokenMatch(target, query)) {
                return false;
            }
        }
        return true;
    }

    public int expressiveWords(String S, String[] words) {
        List<Token> sTokenList = tokenize(S);
        int count = 0;
        for (String word : words) {
            if (checkTokenListMatch(sTokenList, tokenize(word))) {
                count++;
            }
        }
        return count;
    }
}
