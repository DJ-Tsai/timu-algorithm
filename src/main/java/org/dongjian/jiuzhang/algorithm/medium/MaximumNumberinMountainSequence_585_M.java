package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
 * Given nums = [1, 2, 4, 8, 6, 3] return 8
 * Given nums = [10, 9, 8, 7], return 10
 */
public class MaximumNumberinMountainSequence_585_M {
    public int mountainSequence(int[] nums) {
        if (null == nums || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1]) {
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid];
                } else {
                    start = mid;
                }
            } else {
                end = mid;
            }
        }

        return Math.max(nums[start],nums[end]);

    }
}
