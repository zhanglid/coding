package com.zhangliang.google;
/*
定义是先increase后decrease，无duplicate，要求 - 判断是否是triangle sorted:iteration 
O(n) - 找min:O(1)
- 找max peak:binary search, O(logn)
- 找target number:按照peak位置分成两半，然后二分，O(log n)
变型题:有一个曲线，曲线的形状是先递减再增加，找曲线的最低点，如果只考虑int怎么做，如果考虑
double怎么做
考虑double的话返回一个range，包含target即可。

*/

public class TriangleArraySearch {
    // o(n)
    public boolean isTriangleSort(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }
        for (; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        return i == nums.length;
    }

    // o()
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        return Math.min(nums[0], nums[nums.length - 1]);
    }

    // o(log(n))
    public int findPeak(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return nums[r] > nums[l] ? r : l;
    }

    // o(log(n))
    public int findTarget(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int peakIndex = findPeak(nums);

        int left = searchInPart(nums, 0, peakIndex, target, true);
        if (left > 0 && nums[left] == target) {
            return left;
        }

        return searchInPart(nums, peakIndex + 1, nums.length - 1, target, false);
    }

    private int searchInPart(int[] nums, int i, int j, int target, boolean increase) {
        if (i > j) {
            return -1;
        }
        int l = i;
        int r = j;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                if (increase) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else {
                if (increase) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }

        if (nums[r] == target) {
            return r;
        }
        return l;
    }
}
