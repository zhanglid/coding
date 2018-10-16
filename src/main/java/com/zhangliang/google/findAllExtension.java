package com.zhangliang.google;
/*
*/

import java.util.ArrayList;
import java.util.List;

public class findAllExtension {
    public List<int[]> solve(String str) {
        List<int[]> ans = new ArrayList<>(); 
        if (str == null || str.length() < 1) {
            return ans;
        }

        for (int i = 0; i < str.length(); i++) {
            int r = i;
            while(r < str.length() && str.charAt(r) == str.charAt(i)) {
                r++;
            }

            if (r - 1 > i) {
                ans.add(new int[]{i, r - 1});
            }
            i = r - 1;
        }

        return ans;
    }
}
