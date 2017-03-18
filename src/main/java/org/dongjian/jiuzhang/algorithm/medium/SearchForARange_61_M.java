package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Have you met this question in a real interview? Yes
 *
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange_61_M {
    public int[] searchRange(int[] A, int target) {
        if (null == A || A.length == 0) {
            return new int[]{-1, -1};
        }

        if (target < A[0] || target > A[A.length - 1]) {
            return new int[]{-1, -1};
        }

        int first, last;
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (target == A[end]) {
            last = end + 1;
        } else {
            last = end;
        }

        start = 0;
        end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target == A[start]) {
            first = start - 1;
        } else {
            first = start;
        }

        if (first == last - 1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first + 1, last - 1};
        }
    }
}
