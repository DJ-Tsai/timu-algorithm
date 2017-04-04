package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * Notice
 * <p>
 * You may assume that each input would have exactly one solution
 * <p>
 * Example
 * Given nums = [2, 7, 11, 15], target = 9
 * return [1, 2]
 */
public class TwoSum_InputArrayIsSorted_608_M {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }

        return null;
    }
}
