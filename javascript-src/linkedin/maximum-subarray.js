/*
[Coding] LeetCode 上 Maximum subarray 的增强版，需要同时输出起始和终止的 index.给一个数组，求最大的 subarray 的 sum 及其坐标 
如 [0, -1, 3, 4, -5, 0] 返回 
{ result: 7, indexes: [2, 3] } 循序渐进，各种解法都过一遍，讨论复杂度，然后最优解写代码(Javascript)，bug free 提前做完，问问题
*/

export function getMaximumSubarray(values) {
    return values.reduce(
        ({ ans, sum, minSum, minSumIndex }, value, index) => {
            sum += value;
            if (ans.result === undefined || ans.result < sum - minSum) {
                ans.result = sum - minSum;
                ans.indexes = [minSumIndex + 1, index];
            }
            if (sum < minSum) {
                minSum = sum;
                minSumIndex = index;
            }
            return { ans, sum, minSum, minSumIndex };
        },
        {
            ans: { result: undefined, indexes: [] },
            sum: 0,
            minSum: 0,
            minSumIndex: -1
        }
    ).ans;
}
