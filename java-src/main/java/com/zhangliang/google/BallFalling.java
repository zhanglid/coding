package com.zhangliang.google;
/*
/ / \ \
\ \ / /
/ / \ \
\ \ / /
两个function:
1.改变某一格的‘\' 或者'/'成为相反
2.从某一列扔下小球，重力作用下问从哪一列出来，比如从第一列扔就返回-1因为飞出去了

给一个m x n 的游戏board如下，如果把一个球从顶部放入，球会沿着通道上下掉。要求写一个drop method，输入是入口编号，输出是球会从哪个口掉出来（或者无法掉下去）
     \//\
     \\//
     \\\\
drop method 直接 O(m) 搞定。
Followup: what to do if want to call drop function many times，我说可以做precomputation，需要O(mn)，然后每次drop method call需要O(1)
Followup: 在此基础上，不仅要支持drop method，还要支持flip method，两个method次数大体一致，需要优化整体的 time complexity。其实还是做precomputation，但是flip call 时需要局部修改 precomputed results，最后应该是首次precompute需要O(mn)，后边flip需要O(m)，drop需要O(1)。楼主面试的时候只有个大概的思路，没有把细节想清楚。面试官说很多人无法搞定这一步，应该是安慰我。

*/

public class BallFalling {

  private char[][] board;

  public BallFalling(char[][] board) {
    this.board = board;
  }

  public void set(int i, int j, char x) {
    board[i][j] = x;
  }

  public int get(int j) {
    for (int i = 0; i < board.length && j >= 0 && j < board[0].length; i++) {
      if (board[i][j] == '/') {
        j--;
      } else {
        j++;
      }
    }
    return j;
  }
}
