package com.zhangliang.google;
/*
设计一个map, map有一个eplison 比如 0.1 key是 double
put ( 2.0, "hello)
get的时候在 如果查询的key在 ( original key - eplison, original key + eplison )的范围内，则返回 original 
key的value. From 1point 3acres bbs
比如这个栗子
get(2.05) -> hello get(1.98) -> hello
*/

import java.util.HashMap;
import java.util.Map;

// ...0.5...1...1.5...2...2.5
public class DoubleMapWithEplision {
    static class DoubleMap<T> {
        private double eplison;
        private Map<Integer, T> map = new HashMap<>();

        public DoubleMap(double eplison) {
            this.eplison = eplison;
        }

        private int transKey(double key) {
            return (int) (eplison / (2 * eplison));
        }

        public void put(double key, T value) {
            int tkey = transKey(key);
            map.put(tkey, value);
        }

        public T get(double key) {
            int tkey = transKey(key);
            if (!map.containsKey(tkey)) {
                return null;
            }
            return map.get(tkey);
        }
    }
}
