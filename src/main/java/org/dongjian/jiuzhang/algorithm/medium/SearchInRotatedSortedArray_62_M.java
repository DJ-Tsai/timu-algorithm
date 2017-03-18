package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * <p>
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 *
 * O(logN)
 */
public class SearchInRotatedSortedArray_62_M {
    public int search(int[] A, int target) {
        if (null == A || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        // A[start] < A[end]
        if (A[start] < A[end]) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (target < A[mid]) {
                    end = mid;
                } else if (target > A[mid]) {
                    start = mid;
                } else {
                    return mid;
                }
            }
        } else {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (target < A[mid]) {
                    if (target < A[0] && A[mid] > A[A.length - 1]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                } else if (target > A[mid]) {
                    if (target > A[A.length - 1] && A[mid] < A[0]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else {
                    return mid;
                }
            }
        }

        if (target == A[start]) {
            return start;
        }

        if (target == A[end]) {
            return end;
        }

        return -1;
    }
}
