package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.
 * <p>
 * Return -1 if there is no element in the array.
 */
public class ClosestNumberinSortedArray_459_E {
    public int closestNumber(int[] A, int target) {
        if (null == A || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > A[mid]) {
                start = mid;
            } else if (target == A[mid]) {
                return mid;
            } else {
                end = mid;
            }
        }

        if (target == A[start]) {
            return start;
        }

        if (target == A[end]) {
            return end;
        }

        return (target - A[start]) > (A[end] - target) ? end : start;
    }
}
