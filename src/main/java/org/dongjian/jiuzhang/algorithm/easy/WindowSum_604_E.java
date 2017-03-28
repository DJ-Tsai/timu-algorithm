package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.
 * <p>
 * Example
 * For array [1,2,7,8,5], moving window size k = 3.
 * 1 + 2 + 7 = 10
 * 2 + 7 + 8 = 17
 * 7 + 8 + 5 = 20
 * return [10,17,20]
 */
public class WindowSum_604_E {
    public int[] winSum(int[] nums, int k) {
        if (null == nums || nums.length == 0 || nums.length < k) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            res[0] = res[0] + nums[i];
        }

        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + nums[i - 1 + k] - nums[i - 1];
        }

        return res;
    }
}
