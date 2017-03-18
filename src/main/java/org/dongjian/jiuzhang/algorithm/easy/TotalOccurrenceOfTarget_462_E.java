package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.
 * <p>
 * Given [1, 3, 3, 4, 5] and target = 3, return 2.
 * <p>
 * Given [2, 2, 3, 4, 6] and target = 4, return 1.
 * <p>
 * Given [1, 2, 3, 4, 5] and target = 6, return 0.
 */
public class TotalOccurrenceOfTarget_462_E {
    public int totalOccurrence(int[] A, int target) {
        /*
        Some thoughts:
        Binary search (XXOO)
        two loop:
        first loop: find last target
        second loop: find first target

        workflow:
        1. corner case
        2. two loop
        3. get the total occurrence of target
        */

        if (null == A || A.length == 0 || A[0] > target || A[A.length - 1] < target) {
            return 0;
        }

        int lastTarget, firstTarget;
        int start = 0;
        int end = A.length - 1;

        // first loop: find index of first # larger than target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] == target) {
            lastTarget = end;
        } else {
            lastTarget = start;
        }

        start = 0;
        end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] == target) {
            firstTarget = start;
        } else {
            firstTarget = end;
        }

        if (end < start) {
            return 0;
        } else {
            return (lastTarget - firstTarget + 1);
        }
    }
}
