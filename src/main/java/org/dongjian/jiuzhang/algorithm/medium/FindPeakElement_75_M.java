package org.dongjian.jiuzhang.algorithm.medium;

/**
 * There is an integer array which has the following features:
 * <p>
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * We define a position P is a peek if:
 * <p>
 * A[P] > A[P-1] && A[P] > A[P+1]
 * Find a peak element in this array. Return the index of the peak.
 *
 * Notice: The array may contains multiple peeks, find any of them.me
 */
public class FindPeakElement_75_M {
    public int findPeak(int[] A) {
        // since A[0] < A[1] && A[A.length - 2] > A[A.length - 1]
        // there must be at least one peak

        // there are at least three numbers, no check needed for corner case
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] < A[mid]) {
                if (A[mid + 1] < A[mid]) {
                    return mid;
                } else {
                    start = mid;
                }
            } else {
                end = mid;
            }
        }

        return A[start] > A[end] ? start : end;
    }
}
