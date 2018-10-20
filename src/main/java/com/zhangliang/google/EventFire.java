package com.zhangliang.google;
/*
implement一个event_fire function, 每当有一个event的时候就会调用这个function, input为当前的时间
如果在过去t秒内有超过n个event call了，就return True，否则return False。follow up是优化 worst case和space。
假设event的总数为N, 我最开始的思路是用queue, 每当有新的event的时候就放到queue尾，然后 从queue的头部开始比对event
是不是outdated, 如果是就pop出去，最后判断下queue的长度是不 是长于n, 这样的话amortized时间复杂度是O(1)，但是worst case
下时间和空间均可能为O(N)。 优化完的思路为每次把新的event放到队尾后，如果queue的长度大于n，就一直pop到n个为止， 然后判断queue
的头有没有outdated, 这样space不会超过n, worst case时间复杂度也是O(1)， 其 实就换了个判断的思路。
*/

import java.util.Arrays;

public class EventFire {
    private int fireInterval;
    private int[] queue;
    private int index = 0;

    public EventFire(int t, int n) {
        fireInterval = t;
        queue = new int[n];
        Arrays.fill(queue, -1);
    }

    public boolean fire(int timestamp) {
        boolean ans = false;
        int next = (index + 1) % queue.length;
        if (queue[next] != -1 && timestamp - queue[next] < fireInterval) {
            ans = true;
        }
        queue[index] = timestamp;
        index  = next;
        return ans;
    }
}
