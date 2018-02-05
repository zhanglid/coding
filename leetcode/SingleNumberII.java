
/*** Problem *************************************************
Given an array of integers, every element appears three times 
except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could 
you implement it without using extra memory?
**************************************************************/

/*
*
* Solution: 32位整数，如果某个数出现了3次，那么其对应为1的bit位累计数量会增加3。对于出现了一次的数，会在对应bit上+1。
*           可以通过对每一bit的数量进行mod 3，来找到出现一次的那个数对应bit。
* Corner case: [2,2,3,2] => 3, 2!: 16里counts应该是+=累加关系
*              [-2,-2,1,1,-3,1,-3,-3,-4,-2] => 0, -4!: 输入可能包含负数，15中循环结束条件不能是 num > 0， 应该是 num != 0
* 
* Complexity: time: O(n), space: O(1)
*/



class SingleNumberII {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int[] counts = new int[32];
        for (int num : nums) {
            int i = 0;
            while(num != 0) {
                counts[i++] += num & 1; // = => +=
                num = num >>> 1;
            }
        }
        
        int ans = 0;
        int base = 1;
        for (int i = 0; i < 32; i++) {
            ans += (counts[i] % 3) * base;
            // System.out.println(i + " => " + counts[i]);
            base = base << 1;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        SingleNumberII s = new SingleNumberII();
        System.out.println(s.singleNumber(new int[]{4,2,2,2}));
    }
}