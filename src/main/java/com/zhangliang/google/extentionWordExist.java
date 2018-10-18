package com.zhangliang.google;
/*
是给你一个字典，字典中的单词都是不含extension的。然后给你一个单词，可能有 extenstion
可能没有，问​去掉了extension的这个单词在不在字典里​。例如，输入是一个有很多 extension
的单词，比如heeellooo，hiiii，字典是[hello，hi，word]，问你输入的词精简后在不 在字
典里，比如heeellooo精简后可能是hello，所以在字典里，catttt精简后是cat或者是catt，
不在 字典里。
*/

public class extentionWordExist {
    public boolean solve(String[] strs, String target) {
        if (strs == null || target == null) {
            return false;
        }

        for (String str : strs) {
            if (isMatch(str, target)) {
                return true;
            }
        }

        return false;
    }

    private boolean isMatch(String a, String b) {
        // a: shorter string
        // b: longer string
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = i; j <= b.length(); j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    continue;
                }
                int l = j - 1;
                while (l > 0 && b.charAt(l - 1) == a.charAt(i - 1)) {
                    l--;
                }
                if (j - l < 3) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = dp[i - 1][l] || i - 2 > 0 && a.charAt(i - 2) == b.charAt(i - 1) && dp[i - 2][l];
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
