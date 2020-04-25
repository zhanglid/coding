package com.zhangliang.google;
/*
input是int[] speeds 长度是n 每个值的范围是1到n​, 没有duplicate​。描述了一个cluster的概念 ，
example: {2, 4} 车速为4的位置但是并不能用4的速度来开，因为前面的车速为2。所以这两个 车是一个
cluster。再比如{2，4，3}, 3虽然比4小但是不能开到3因为前车是2.所以这三个车也是一 个cluster。
{2,4,3,1,5} 的话 2,4,3是一个cluster，1,5是一个cluster 要去输出List<Integer> 为各个 cluster的长度。

Follow-up:
黑姐姐说你刚才的那个function已经存在了 List<Integer> clustersLens(int[] speeds). 
现在我要加一个车速n+1到speeds里面，我能插入的位置是0-n这n+1个index。每插入不同的位置 新的List<Integer> 
clusterLens 会变成什么样。
*/

import java.util.ArrayList;
import java.util.List;

public class SpeedCluster {
    public List<Integer> clustersLens(int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        if (speeds == null || speeds.length < 1) {
            return ans;
        }
        int curHead = speeds[0];
        int curSize = 1;
        for (int i = 1; i < speeds.length; i++) {
            if (speeds[i] >= curHead) {
                curSize++;
            } else {
                ans.add(curSize);
                curHead = speeds[i];
                curSize = 1;
            }
        }
        if (curSize != 1) {
            ans.add(curSize);
        }
        return ans;
    }
}
