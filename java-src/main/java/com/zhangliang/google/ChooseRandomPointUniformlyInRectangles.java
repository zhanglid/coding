package com.zhangliang.google;
/*
Given a list of rectangles which are ​not intersect with others​, each 
rectangle has four points, write a method to choose a point uniformly 
for the list of rectangles

1 算所有的矩形的面积和 S 然后给每一个矩形分配一个对应的区间 比如 3个矩形的面积分别是1 ，
4，9 那可以分别分配[0,1],[1,5],[5,14]

2 随机产生[0，S] 里的数 通过这个数落在哪个区间里来决定哪个矩形被选中.

3 在这个矩形里 根据分别在x 和y 的方向上产生随机坐标 得到的点就是符合要求的点

Follow-up: 
given a list of rectangles, write a method to choose a random 
point uniformly in the list of rectangles (​maybe overlapped​)
初步想法是process一遍所有的矩形，处理掉overlap的部分，然后以面积为weight，sample
出在 哪个矩形取点，然后再sample取哪个点
看了地里面的面经:第一种是找一个最小的大框 把重叠的 矩形都包含住。然后在大框被 随机选点。
如果选的点不被包含在任何一个已有的矩阵里面的话 就再次随机选点 知道选中为止。第二种 是对
重叠的矩形进行分割
*/

import java.util.ArrayList;
import java.util.List;

public class ChooseRandomPointUniformlyInRectangles {
    static class Reactangle {
        int[] leftDown;
        int[] rightTop;

        public Reactangle(int[] left, int[] right) {
            leftDown = new int[2];
            leftDown[0] = left[0];
            leftDown[1] = left[1];

            rightTop = new int[2];
            rightTop[0] = right[0];
            rightTop[1] = right[1];
        }
    }

    public int[] choosePointWithoutOverlap(List<Reactangle> rects) {
        List<int[]> intervals = new ArrayList<>();
        int sum = 0;
        for (Reactangle rect : rects) {
            int area = (rect.rightTop[0] - rect.leftDown[0]) * (rect.rightTop[1] - rect.leftDown[1]);
            intervals.add(new int[] { sum, sum + area });
            sum += area;
        }
        int rand = (int) Math.random() * sum;
        int i = 0;
        for (i = 0; i < rects.size(); i++) {
            if (rand >= intervals.get(i)[0] && rand <= intervals.get(i)[1]) {
                break;
            }
        }
        Reactangle target = rects.get(i);
        int[] ans = new int[2];
        ans[0] = target.leftDown[0] + (int) (Math.random() * (target.rightTop[0] - target.leftDown[0]));
        ans[1] = target.leftDown[1] + (int) (Math.random() * (target.rightTop[1] - target.leftDown[1]));
        return ans;
    }
}
