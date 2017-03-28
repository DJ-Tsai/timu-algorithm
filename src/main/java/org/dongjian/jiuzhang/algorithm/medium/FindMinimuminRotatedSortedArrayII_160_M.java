package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * Notice
 * <p>
 * The array may contain duplicates.
 */
public class FindMinimuminRotatedSortedArrayII_160_M {
    public int findMin(int[] num) {
        return helper(num, 0, num.length - 1);
    }

    private int helper(int[] num, int start, int end) {
        if (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int leftMin = helper(num, start, mid);
            int rightMin = helper(num, mid + 1, end);
            return Math.min(leftMin, rightMin);
        }

        return Math.min(num[start], num[end]);
    }
}
