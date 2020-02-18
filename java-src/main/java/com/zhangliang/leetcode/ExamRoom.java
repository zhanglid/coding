package com.zhangliang.leetcode;
/*
In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  
If there are multiple such seats, they sit in the seat with the lowest number.  
(Also, if no one is in the room, then the student sits at seat number 0.)

Return a class ExamRoom(int N) that exposes two functions: 
ExamRoom.seat() returning an int representing what seat the student sat in, 
and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  
It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.

 

Example 1:

Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
Output: [null,0,9,4,2,null,5]
Explanation:
ExamRoom(10) -> null
seat() -> 0, no one is in the room, then the student sits at seat number 0.
seat() -> 9, the student sits at the last seat number 9.
seat() -> 4, the student sits at the last seat number 4.
seat() -> 2, the student sits at the last seat number 2.
leave(4) -> null
seat() -> 5, the student sits at the last seat number 5.
​​​​​​​

Note:

1 <= N <= 10^9
ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
*/

import java.util.*;

public class ExamRoom {
    private int getDist(int[] a) {
        int pos = getPos(a);
        if (pos == a[0] || pos == a[1]) {
            return 0;
        }
        if (pos == 0) {
            return a[1];
        }
        if (pos == N - 1) {
            return pos - a[0];
        }
        return Math.min(pos - a[0], a[1] - pos);
    }

    private int getPos(int[] choice) {
        if (choice[0] == -1) {
            return 0;
        }
        if (choice[1] == N) {
            return N - 1;
        }
        return (choice[0] + choice[1]) / 2;
    }

    // Store all intervals in order
    TreeSet<int[]> ts = new TreeSet<>(new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            int diff = a[1] - b[1];
            return diff == 0 ? a[0] - b[0] : diff;
        }
    });

    // Store all intervals by priority.
    TreeSet<int[]> choiceTs = new TreeSet<>(new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            int lenDiff = getDist(b) - getDist(a);
            return lenDiff == 0 ? a[0] - b[0] : lenDiff;
        }
    });

    int N;

    public ExamRoom(int N) {
        this.N = N;
        int[] initIv = new int[] { -1, N };
        ts.add(initIv);
        choiceTs.add(initIv);
    }

    public int seat() {
        int[] choice = choiceTs.first();
        if (getDist(choice) == 0) {
            return -1;
        }
        int pos = getPos(choice);
        choiceTs.pollFirst();
        ts.remove(choice);
        int[] left = new int[] { choice[0], pos };
        int[] right = new int[] { pos, choice[1] };
        choiceTs.add(left);
        choiceTs.add(right);
        ts.add(left);
        ts.add(right);
        return pos;
    }

    public void leave(int p) {
        int[] left = ts.floor(new int[] { N, p });
        int[] right = ts.ceiling(new int[] { 0, p + 1 });
        if (left[1] != p || right[0] != p) {
            return;
        }
        ts.remove(left);
        ts.remove(right);
        choiceTs.remove(left);
        choiceTs.remove(right);
        int[] merged = new int[] { left[0], right[1] };
        ts.add(merged);
        choiceTs.add(merged);
    }

}
