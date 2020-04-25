package com.zhangliang.leetcode;

import java.util.*;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:


Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

public class TwoSum {
	class Node {
		int val;
		int index;

		public Node(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	public int[] twoSum(int[] nums, int target) {
		Node[] nodes = new Node[nums.length];
		for (int i = 0; i < nums.length; i++) {
			nodes[i] = new Node(nums[i], i);
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return a.val - b.val;
			}
		});
		int l = 0;
		int r = nums.length - 1;
		int[] ans = null;
		while (l < r) {
			int sum = nodes[l].val + nodes[r].val;
			if (sum < target) {
				l++;
			} else if (sum > target) {
				r--;
			} else {
				ans = new int[] { nodes[l].index, nodes[r].index };
				break;
			}
		}

		return ans;
	}
}
