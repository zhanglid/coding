import java.util.*;

/*
On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.

A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

Examples:

Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
Input: board = [[3,2,4],[1,5,0]]
Output: 14
Note:

board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
*/


/*
*  Solution: bfs search, use the set to store the searched board.
*
*  Corner Case: 
*
*  Complexity: Totally, there are 6! cases.
*/

class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length != 2 || board[0].length != 3) {
            return -1;
        }
        
        int zi = -1;
        int zj = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zi = i;
                    zj = j;
                }
            }
        }
        
        if (zi == -1 || zj == -1) {
            return -1;
        }
        
        return bfs(board, zi, zj);
    }
    
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private int bfs(int[][] board, int zi, int zj) {
        Queue<String> queue = new LinkedList<>();
        Set<String> cache = new HashSet<>();
        String start = getkey(board);
        String target = "12345012";
        int step = 0;
        queue.offer(start);
        cache.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                // System.out.println(status.length());
                if (status.equals(target))
                    return step;
                int[][] boardnow = decode(status);
                int[] pos = getPos(status);
                for (int[] dir : dirs) {
                    int x = dir[0] + pos[0];
                    int y = dir[1] + pos[1];
                    if (x < 0 || x >= 2 || y < 0 || y >= 3) {
                        continue;
                    }
                    swap(boardnow, pos[0], pos[1], x, y);
                    String nextKey = getkey(boardnow);
                    if (!cache.contains(nextKey)) {
                        queue.offer(nextKey);
                        cache.add(nextKey);
                    }
                    swap(boardnow, pos[0], pos[1], x, y);
                }
            }
            
            step++;
        }
        
        return -1;
    }
    
    private void swap(int[][] board, int i, int j, int ti, int tj) {
        int x = board[i][j];
        board[i][j] = board[ti][tj];
        board[ti][tj] = x;
    }
    
    private String getkey(int[][] board) {
        StringBuilder sb = new StringBuilder();
        int zi = 0;
        int zj = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
                if (board[i][j] == 0) {
                    zi = i;
                    zj = j;
                }
            }
        }
        
        sb.append(zi);
        sb.append(zj);
        return sb.toString();
    }
    
    private int[][] decode(String key) {
        int[][] board = new int[2][3];
        int t = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = key.charAt(t++) - '0';
            }
        }
        
        return board;
    }
    
    private int[] getPos(String key) {
        int[] ans = new int[2];
        ans[1] = key.charAt(key.length() - 1) - '0';
        ans[0] = key.charAt(key.length() - 2) - '0';
        return ans;
    }


    public static void main(String[] args) {
        SlidingPuzzle s = new SlidingPuzzle();
        System.out.println(s.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
    }
}