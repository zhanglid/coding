package com.zhangliang.algorithm;
/*
Example: int a[i] = {-1, -3, 4, 7} => 
iteration 1: find global min =3
*/

// selection sort an array a[] with size n
public class SelectionSort {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
