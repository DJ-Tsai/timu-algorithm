package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume NO duplicates in the array.
 * <p>
 * Example
 * [1,3,5,6], 5 → 2
 * <p>
 * [1,3,5,6], 2 → 1
 * <p>
 * [1,3,5,6], 7 → 4
 * <p>
 * [1,3,5,6], 0 → 0
 *
 * Challenge
 * O(log(n)) time
 */
public class SearchInsertPosition_60_E {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (A[mid] < target) {
                left = mid;
            } else if (A[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        if (A[right] < target) {
            return right + 1;
        }

        if (A[left] < target) {
            return right;
        } else {
            return left;
        }
    }
}
