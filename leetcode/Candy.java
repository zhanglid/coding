package leetcode;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

/*
Solution: 
    限制条件为rating更高的同学得到更多的candy，可以拆分为两个方向。如果rating比左边高，那么
    这个同学一定要比左边的candy多，右边同理。于是每个同学有两个限制条件需要同时满足，这两个条件
    都设定了下限，于是去其最大值。
Complexity: 
    O(n)两遍
Corner case:
    [1,2,2] => 4: 题目只说如果rating高，那么candy也多。并没有说rating一样，candy也要一样。这样
    index为2的同学没有必要和index为1的同学一样多candy。于是结果为1 + 2 + 1 = 4
*/


class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }
        int[] nums = new int[ratings.length];
        int count = 1;
        for (int i = 0; i < ratings.length - 1; i++) {
            nums[i] = count;
            if (ratings[i] < ratings[i + 1]) {
                count++;
            }
            
            if (ratings[i] >= ratings[i + 1]) { // corner case: [1,2,2] => 4
                count = 1;
            }
        }
        nums[nums.length - 1] = count;
        count = 1;
        int ans = 0;
        for (int i = ratings.length - 1; i > 0; i--) {
            ans += Math.max(count, nums[i]);
            if (ratings[i] < ratings[i - 1]) {
                count++;
            }
            
            if (ratings[i] >= ratings[i - 1]) { // corner case: [1,2,2] => 4
                count = 1;
            }
        }
        ans += Math.max(count, nums[0]);
        
        return ans;
    }

    public static void main(String[] args) {
        Candy s = new Candy();
        System.out.println(s.candy(new int[]{1,2,2}));
    }
}