package com.zhangliang.laioffer;
/*
  A1B2C3D4 -> ABCD1234

  Assumptions: 
    Input is a string like A1B2C3D4

  Approach: 
    Merge sort
                    A1B2C3D4
                  /         \               o(1)
              A1B2          C3D4
              /  \        /     \  
            A1    B2    C3       D4          o(n)
          ===========================
           A1     B2    C3      D4           o(n)
            \     /       \    / 
              AB12        CD34               o(n)        
                \          /
                  ABCD1234               

  DataStructure: 

  Complexity: 
      Time: o(nlogn)
      Space: o(n)

*/

public class MergeAbcd {
  private void merge(char[] chars, int i, int mid, int j) {
    int size = mid - i + 1;
    char[] tmp = new char[j - i + 1];

    // A
    for (int t = 0; t < size / 2; t++) {
      tmp[t] = chars[i + t];
    }

    // B
    for (int t = 0; t < size / 2; t++) {
      tmp[size / 2 + t] = chars[mid + 1 + t];
    }

    // 1
    for (int t = 0; t < size / 2; t++) {
      tmp[size + t] = chars[i + size / 2 + t];
    }

    // 2
    for (int t = 0; t < size / 2; t++) {
      tmp[size + size / 2 + t] = chars[mid + 1 + size / 2 + t];
    }

    for (int t = 0; t < j - i + 1; t++) {
      chars[i + t] = tmp[t];
    }
  }

  private void sort(char[] chars, int i, int j) {
    if (i + 1 == j) {
      return;
    }
    int mid = i + (j - i) / 2;
    sort(chars, i, mid);
    sort(chars, mid + 1, j);
    merge(chars, i, mid, j);
  }

  public String transform(String s) {
    char[] chars = s.toCharArray();
    sort(chars, 0, chars.length - 1);
    return new String(chars);
  }
}
