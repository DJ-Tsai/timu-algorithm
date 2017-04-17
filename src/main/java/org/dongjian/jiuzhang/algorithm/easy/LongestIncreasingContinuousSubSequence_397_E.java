package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Give an integer array，find the longest increasing continuous subsequence in this array.
 * <p>
 * An increasing continuous subsequence:
 * <p>
 * Can be from right to left or from left to right.
 * Indices of the integers in the subsequence should be continuous.
 * Notice
 * <p>
 * O(n) time and O(1) extra space.
 * <p>
 * Example
 * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 * <p>
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 */
public class LongestIncreasingContinuousSubSequence_397_E {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                len = 1;
            }
        }

        len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                len = 1;
            }
        }

        return maxLen;
    }
}
