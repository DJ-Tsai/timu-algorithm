package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.
 * <p>
 * Example
 * Given nums = [2, 7, 11, 15], target = 24.
 * Return 5.
 * 2 + 7 < 24
 * 2 + 11 < 24
 * 2 + 15 < 24
 * 7 + 11 < 24
 * 7 + 15 < 25
 */
public class TwoSum_LessThanOrEqualToTarget_609_M {
    public int twoSum5(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                count = count + end - start;
                start++;
            }
        }

        return count;
    }
}
