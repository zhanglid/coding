/*

We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

Return true if and only if the number of global inversions is equal to the number of local inversions.

Example 1:

Input: A = [1,0,2]
Output: true
Explanation: There is 1 global inversion, and 1 local inversion.
Example 2:

Input: A = [1,2,0]
Output: false
Explanation: There are 2 global inversions, and 1 local inversion.
Note:

A will be a permutation of [0, 1, ..., A.length - 1].
A will have length in range [1, 5000].
The time limit for this problem has been reduced.

*/

/*
*  Solution: one pass, 如果比之前的一个大那ok，如果比之前的一个小，那么要确保不能小于更多元素。
             意味着比除了之前一个的前面所有的最大值要大。
*
*  Corner Case: [0,2,1] => true, false!: 注意，是要大于之前一个的之前所有的最大值。
*
*  Complexity: Totally, there are 6! cases.
*/


class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length < 3) {
            return true;
        }
        
        int preMax = A[0];
        
        for (int i = 2; i < A.length; i++) {
            if (A[i] < preMax) {
                return false;
            }
            preMax = Math.max(preMax, A[i - 1]);
        }
        
        return true;
    }

    public static void main(String[] args) {
        GlobalAndLocalInversions s = new GlobalAndLocalInversions();
        System.out.println(s.isIdealPermutation(new int[]{1,0,2}));
    }
}