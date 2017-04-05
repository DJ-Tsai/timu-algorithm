package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.
 * <p>
 * Example
 * Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
 * <p>
 * Do it in O(1) extra space and O(nlogn) time.
 */
public class TwoSum_GreaterThanTarget_443_M {
    public int twoSum2(int[] nums, int target) {
        int count = 0;

        if (nums == null || nums.length <= 1) {
            return count;
        }
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] > target) {
                count = count + j - i;
                j--;
            } else {
                i++;
            }
        }

        return count;
    }
}
