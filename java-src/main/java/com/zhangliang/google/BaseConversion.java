package com.zhangliang.google;

/*
白人帅哥，也很耐心
given
1. a number in the form of string
2. input base
3. output base
e.g. ("1A", 16, 2)

求 return the number of the output base in the form of string
上面的例子答案是16+10=26，26=binary 11010
基本思路是把input base和output base分别建一个与十进制转换关系表来, 然后把输入数转成十进制，然后再把十进制转成输出进制。

input base16：to base10
0=0
1=1
...
A=10
B=11
..
上面的例子是base2，比如是base13的话, base10 to base13
0=0
1=1
...
9=9
10=A
11=B
12=C
这个解法的问题是会有数字超大溢出
*/

public class BaseConversion {
  private char toChar(int val) {
    if (val < 10) {
      return (char) (val + '0');
    }
    return (char) (val - 10 + 'A');
  }

  private int toVal(char x) {
    if (Character.isDigit(x)) {
      return x - '0';
    }
    return x - 'A' + 10;
  }

  private int divide(char[] digits, int n, int base, int divisor) {
    int carrier = 0;
    int first = digits.length - n;
    for (int i = first; i < digits.length; i++) {
      int d = carrier + toVal(digits[i]);
      carrier = d % divisor;
      digits[i] = toChar(d / divisor);
      carrier = (d % divisor) * base;
      if (digits[first] == toChar(0)) {
        first++;
      }
    }
    return digits.length - first;
  }

  public String solve(String num, int base, int tBase) {
    StringBuilder sb = new StringBuilder();
    char[] digits = num.toCharArray();
    int n = digits.length;
    while (n > 0) {
      int mod = 1;
      int val = 0;
      for (int i = digits.length - 1; i >= digits.length - n; i--) {
        int d = toVal(digits[i]);
        val = (val + (d % tBase) * mod) % tBase;
        mod = (mod * (base % tBase)) % tBase;
      }

      sb.append(toChar(val));
      n = divide(digits, n, base, tBase);
    }

    sb.reverse();

    return sb.toString();
  }
}
