package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.
 * <p>
 * Example
 * Given nums = [1,1,2,45,46,46], target = 47
 * return 2
 * <p>
 * 1 + 46 = 47
 * 2 + 45 = 47med
 */
public class TwoSum_UniquePairs_587_M {
    public int twoSum6(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int num1 = nums[start];
            int num2 = nums[end];

            if (num1 + num2 > target) {
                while (nums[end] == num2 && end > start) {
                    end--;
                }
            } else if (num1 + num2 < target) {
                while (nums[start] == num1 && end > start) {
                    start++;
                }
            } else {
                count++;
                while (nums[end] == num2 && end > start) {
                    end--;
                }
                while (nums[start] == num1 && start < end) {
                    start++;
                }
            }
        }

        return count;
    }
}
