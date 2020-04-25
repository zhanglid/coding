package com.zhangliang.linkedin;
/*
给一个 output 是 0 或 1 的随机数生成器，0 的概率是 p，1 的概率是 1-p     
求写一个生成 0，1 概率是 50/50 的函数
*/

import java.util.*;

public class RandomGenerator {
    class PRandomGenerator {
        private Random rand;

        public PRandomGenerator() {
            rand = new Random();
        }

        public int nextInt() {
            return rand.nextInt(1000) < 100 ? 0 : 1;
        }
    }

    PRandomGenerator pGenerator = new PRandomGenerator();

    public int generate() {
        int a = pGenerator.nextInt();
        int b = pGenerator.nextInt();
        int c = pGenerator.nextInt();
        int d = pGenerator.nextInt();
        while (a == b || c == d) {
            a = pGenerator.nextInt();
            b = pGenerator.nextInt();
            c = pGenerator.nextInt();
            d = pGenerator.nextInt();
        }
        return (a == 1 && b == 0) ? 0 : 1;
    }
}
