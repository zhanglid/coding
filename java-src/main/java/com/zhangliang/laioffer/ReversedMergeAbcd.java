package com.zhangliang.laioffer;
/*
  ABCD1234 -> A1B2C3D4

  Assumptions: 
    Valid input.

  Approach: 
    Merge sort.

               ABCD1234 
               /      \
           AB12       CD34
           /  \       /  \ 
         A1   B2    C3   D4
        =====================
         A1   B2    C3   D4

          A1B2       C3D4           
            \         /
              A1B2C3D4 

  DataStructure: 

  Complexity: 
      Time: 
      Space: 
*/

import java.util.Arrays;

public class ReversedMergeAbcd {
  private void sortRange(char[] chars, int i, int j) {
    if (i == j) {
      return;
    }
    int mid = i + (j - i) / 2;
    int size = j - i + 1;
    int chunkSize = size / 4;

    for (int t = 0; t < chunkSize; t++) {
      char ch = chars[i + t + chunkSize];
      chars[i + t + chunkSize] = chars[i + t + 2 * chunkSize];
      chars[i + t + 2 * chunkSize] = ch;
    }

    sortRange(chars, i, mid);
    sortRange(chars, mid + 1, j);
  }

  public String sort(String s) {
    char[] chars = s.toCharArray();
    sortRange(chars, 0, s.length() - 1);
    return new String(chars);
  }
}
