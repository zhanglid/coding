package com.zhangliang.google;
/*
expression可以是：纯数字 或者 ‘<’  function 加0个或多个 expression '>
function可以是：+， -， *， /
求expression的计算结果。
例子：

“123”  ->  123
“<+ 1 2 3>”  -> 6(1 + 2 + 3)
"<*>" -> 1
"<+>" -> 0
"<+ 1 <* 3>>" -> 4
这个很像basic calculator，麻烦的是处理"<+>"这个情况
*/

import java.util.*;

public class EvalExpression {
  private int[] parseInt(String exp, int startIndex) {
    int j = startIndex + 1;
    while (j < exp.length() && Character.isDigit(exp.charAt(j))) {
      j++;
    }
    return new int[] { Integer.parseInt(exp.substring(startIndex, j)), j };
  }

  private int calc(char op, List<Integer> values) {
    int res = op == '*' ? 1 : 0;
    int i = 0;
    if (op == '/') {
      if (values.size() < 1) {
        return 1;
      }
      i++;
      res = values.get(i);
    }
    for (; i < values.size(); i++) {
      int value = values.get(i);
      switch (op) {
        case '*':
          res *= value;
          break;
        case '+':
          res += value;
          break;
        case '-':
          res += value;
          break;
        case '/':
          res /= value;
          break;

        default:
          break;
      }
    }

    return res;
  }

  private int[] parseExp(String exp, int startIndex) {
    if (exp.charAt(startIndex) != '<') {
      return parseInt(exp, startIndex);
    }
    int endIndex = exp.length();
    char op = exp.charAt(startIndex + 1);
    List<Integer> values = new ArrayList<>();
    for (int i = startIndex + 2; i < exp.length(); i++) {
      char x = exp.charAt(i);
      if (x == ' ') {
        continue;
      } else if (x == '>') {
        endIndex = x;
        break;
      }
      int[] r = parseExp(exp, i);
      values.add(r[0]);
      i = r[1];
    }

    return new int[] { calc(op, values), endIndex };
  }

  public int eval(String exp) {
    return parseExp(exp, 0)[0];
  }
}
