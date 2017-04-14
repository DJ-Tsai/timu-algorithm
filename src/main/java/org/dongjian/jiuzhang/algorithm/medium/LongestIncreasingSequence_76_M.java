package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * <p>
 * You code should return the length of the LIS.
 * <p>
 * Clarification
 * What's the definition of longest increasing subsequence?
 * <p>
 * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 * <p>
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * <p>
 * Example
 * For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
 * <p>
 * Challenge
 * Time complexity O(n^2) or O(nlogn)
 */
public class LongestIncreasingSequence_76_M {
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length];

        // init
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
        }


        // DP
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                }
            }
        }

        int max = 1;

        for (int i = 0; i < f.length; i++) {
            if (f[i] > max) {
                max = f[i];
            }
        }

        return max;
    }
}
