package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
 * <p>
 * Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
 * <p>
 * Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
 *
 * NOTE: O(logn + k) time complexity.
 */
public class KClosestNumbersInSortedArray_460_M {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (null == A || A.length == 0) {
            return null;
        }

        if (A.length < k) {
            return Arrays.copyOf(A, A.length);
        }

        int[] result = new int[k];

        if (A[0] >= target) {
            return (int[]) Arrays.copyOfRange(A, 0, k);
        }

        if (A[A.length - 1] <= target) {
            for (int i = 0; i < k; i++) {
                result[i] = A[A.length - 1 - i];
            }
            return result;
        }


        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int index = 0;
        while (index <= k - 1 && start >= 0 && end <= A.length - 1) {
            if (target - A[start] > A[end] - target) {
                result[index] = A[end];
                end++;
                index++;
            } else {
                result[index] = A[start];
                start--;
                index++;
            }
        }

        if (start < 0) {
            for (int i = 0; i < k - index; i++) {
                result[index + i] = A[end + i];
            }
        }

        if (end > A.length - 1) {
            for (int i = 0; i < k - index; i++) {
                result[index + i] = A[start - i];
            }
        }

        return result;
    }
}
