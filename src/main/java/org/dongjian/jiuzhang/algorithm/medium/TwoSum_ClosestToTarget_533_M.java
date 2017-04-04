package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
 * <p>
 * Return the difference between the sum of the two integers and the target.
 *
 * Example
 * Given array nums = [-1, 2, 1, -4], and target = 4.
 * <p>
 * The minimum difference is 1. (4 - (2 + 1) = 1).
 * <p>
 * Challenge
 * Do it in O(nlogn) time complexity.
 */
public class TwoSum_ClosestToTarget_533_M {
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] < target) {
                if (target - nums[start] - nums[end] < res) {
                    res = target - nums[start] - nums[end];
                }
                start++;
            } else if (nums[start] + nums[end] > target) {
                if (nums[start] + nums[end] - target < res) {
                    res = nums[start] + nums[end] - target;
                }
                end--;
            } else {
                return 0;
            }
        }

        return res;
    }
}
