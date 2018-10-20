package com.zhangliang.google;
/*
給定一个全是0和1的matrix, 只给定两种操作，分别是toggle一行和toggle一列，
问能不能把matrix 全变成1.

example 1

[
 [1, 0],
 [0, 1]
]

output:
false

example 2
[
 [0, 0],
 [1, 1]
]

output:
true

example 3
[
 [0, 1],
 [1, 1]
]

output:
false

我用的是DFS+记录，就是把当前matrix的状态作为一个点，然后做dfs. 面试官给的
方法是根据操作可以交换性(先把第一行toggle，再toggle第一列和反过来是一样的)， 
假设是m*n的矩阵，每一行或一列要么toggle要么没有，所有可能的操作方案为2^(m+n),
试试就好 了。具体实现的话如果m和n不是很大，可以枚举二进制数，来遍历所有操作方案。
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ToggleMatrixToOne {
    private boolean canToggleToOne(int[][] matrix, Boolean[] rowToggle, Boolean[] colToggle) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean state = matrix[i][j] == 1;
                if (rowToggle[i]) {
                    state = !state;
                }
                if (colToggle[i]) {
                    state = !state;
                }
                if (!state) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Stack<List<Boolean>> stack = new Stack<>();
        stack.push(new LinkedList<Boolean>());
        while (!stack.isEmpty()) {
            List<Boolean> rowToggles = stack.pop();
            if (rowToggles.size() < m) {
                stack.push(new LinkedList<Boolean>(rowToggles));
                stack.peek().add(true);
                stack.push(new LinkedList<Boolean>(rowToggles));
                stack.peek().add(false);
            } else {
                Stack<List<Boolean>> colStack = new Stack<>();
                colStack.push(new LinkedList<Boolean>());
                while (!colStack.isEmpty()) {
                    List<Boolean> colToggles = colStack.pop();
                    if (colToggles.size() < n) {
                        colStack.push(new LinkedList<Boolean>(colToggles));
                        colStack.peek().add(true);
                        colStack.push(new LinkedList<Boolean>(colToggles));
                        colStack.peek().add(false);
                    } else {
                        if (canToggleToOne(matrix, rowToggles.toArray(new Boolean[0]),
                                colToggles.toArray(new Boolean[0]))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
