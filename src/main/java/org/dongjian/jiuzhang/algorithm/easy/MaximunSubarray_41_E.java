package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * <p>
 * Notice
 * <p>
 * The subarray should contain at least one number.
 * <p>
 * Example
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * Can you do it in time complexity O(n)?
 */
public class MaximunSubarray_41_E {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum, minSum, curSum;
        maxSum = nums[0];
        minSum = nums[0];
        curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = curSum + nums[i];
            if (curSum - minSum > maxSum) {
                maxSum = curSum - minSum;
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }

            if (curSum < minSum) {
                minSum = curSum;
            }
        }
        return maxSum;
    }
}
