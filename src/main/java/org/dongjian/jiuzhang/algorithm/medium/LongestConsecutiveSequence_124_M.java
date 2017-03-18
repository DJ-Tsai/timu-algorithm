package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Created by Dj on 1/30/17.
 */
public class LongestConsecutiveSequence_124_M {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }

            if (nums[i] + 1 == nums[i + 1]) {
                count = count + 1;
                continue;
            }

            if (count != 1) {
                max = Math.max(max, count);
                count = 1;
            }
        }

        if (count != 1) {
            max = Math.max(max, count);
        }

        return max;
    }
}
