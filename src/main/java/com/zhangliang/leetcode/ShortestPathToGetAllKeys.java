package com.zhangliang.leetcode;
/*
We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) 
are keys, and ("A", "B", ...) are locks.

We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  
We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a 
lock unless we have the corresponding key.

For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English 
alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also 
that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.

Example 1:

Input: [
        "@.a.#",
        "###.#",
        "b.A.B"
    ]
Output: 8
Example 2:

Input: [
        "@..aA",
        "..B#.",
        "....b"
    ]
Output: 6
 

Note:

1 <= grid.length <= 30
1 <= grid[0].length <= 30
grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {
    private class State {
        public int i;
        public int j;
        public Set<Character> locks;

        public State(int i, int j, Set<Character> openedLocks) {
            this.i = i;
            this.j = j;
            this.locks = openedLocks;
        }

        public boolean isUnlocked(char lock) {
            if (this.locks.contains((char) (lock + 'a' - 'A'))) {
                return true;
            }
            return false;
        }

        public String toString() {
            Character[] chars = locks.toArray(new Character[0]);
            Arrays.sort(chars);
            return Arrays.toString(chars) + i + "," + j;
        }
    }

    final static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int shortestPathAllKeys(String[] grid) {
        Queue<State> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                char x = grid[i].charAt(j);
                if (x == '@') {
                    queue.add(new State(i, j, new HashSet<>()));
                } else if (x >= 'a' && x <= 'a' + 6) {
                    count++;
                }
            }
        }
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add(queue.peek().toString());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State s = queue.poll();
                if (s.locks.size() == count) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int ni = s.i + dir[0];
                    int nj = s.j + dir[1];

                    if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length() || grid[ni].charAt(nj) == '#') {
                        continue;
                    }
                    char t = grid[ni].charAt(nj);
                    State cur = null;
                    if (t == '.' || (t >= 'A' && t <= 'A' + 6 && s.isUnlocked(t))) {
                        cur = new State(ni, nj, s.locks);
                    } else if (t >= 'a' && t <= 'a' + 6) {
                        cur = new State(ni, nj, new HashSet<>(s.locks));
                        cur.locks.add(t);
                    }

                    if (cur != null && !visited.contains(cur.toString())) {
                        visited.add(cur.toString());
                        queue.add(cur);
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
