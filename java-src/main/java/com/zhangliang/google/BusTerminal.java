package com.zhangliang.google;
/*
公交车站里面有若干公共汽车， 类似这样 terminal:{bus1, bus2, bus3, ...}， bus
是一个类， 有int id, String company和一个出发时间 int time. 然后让实现几个函数 :
- add(bus) 向一个车站里加入一辆车
- getnext() 得到下一辆出发的车
- dispatch() 让下一辆车从车站出发
- removeAll(company) 除掉车站中某一个公司的所有车。
问每个函数的时间复杂度。
Map<String, PriorityQueue> companyToQueue，k个company，每个队列长度为L，则
- add(bus): O(logL)
- getNext(): O(k)
- dispatch(): O(k)
- removeAll(company): O(1)
follow up, 自己实现priority queue 来实现上面的每个问题。
*/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BusTerminal {
    static class Bus {
        int id;
        String company;
        int time;

        public Bus(int id, String company, int time) {
            this.id = id;
            this.company = company;
            this.time = time;
        }
    }

    static class Terminal {
        Map<String, PriorityQueue<Bus>> busQueueByCompany = new HashMap<>();

        public void add(Bus bus) {
            if (!busQueueByCompany.containsKey(bus.company)) {
                busQueueByCompany.put(bus.company, new PriorityQueue<>(new Comparator<Bus>() {
                    public int compare(Bus a, Bus b) {
                        return a.time - b.time;
                    }
                }));
            }
            busQueueByCompany.get(bus.company).add(bus);
        }

        public Bus getNext() {
            Bus ans = null;
            for (PriorityQueue<Bus> pq : busQueueByCompany.values()) {
                if (pq.isEmpty()) {
                    continue;
                }
                Bus next = pq.peek();
                if (ans == null || next.time < ans.time) {
                    ans = next;
                }
            }
            return ans;
        }

        public void removeAll(String str) {
            busQueueByCompany.remove(str);
        }
    }
}
