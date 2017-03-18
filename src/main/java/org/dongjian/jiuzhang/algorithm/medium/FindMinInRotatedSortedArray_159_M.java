package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Given [4, 5, 6, 7, 0, 1, 2] return 0m
 */
public class FindMinInRotatedSortedArray_159_M {
    public int findMin(int[] nums) {
        if (null == nums) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int target = nums[nums.length - 1];
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}
