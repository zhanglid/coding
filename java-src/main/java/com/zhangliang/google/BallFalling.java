package com.zhangliang.google;
/*
/ / \ \
\ \ / /
/ / \ \
\ \ / /
两个function:
1.改变某一格的‘\' 或者'/'成为相反
2.从某一列扔下小球，重力作用下问从哪一列出来，比如从第一列扔就返回-1因为飞出去了
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
