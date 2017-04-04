package org.dongjian.jiuzhang.algorithm.hard;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * <p>
 * Example
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * <p>
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 * <p>
 * Challenge
 * The overall run time complexity should be O(log (m+n))   
 */
public class MedianOfTwoSortedArrays_65_H {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            int len = B.length;
            double res = len % 2 == 0 ? (B[len / 2 - 1] + B[len / 2]) / 2.0 : (double) B[len / 2];
            return res;

        }

        if (B == null || B.length == 0) {
            int len = A.length;
            return len % 2 == 0 ? (A[len / 2 - 1] + A[len / 2]) / 2.0 : (double) A[len / 2];
        }

        int lenA = A.length;
        int lenB = B.length;
        int len = lenA + lenB;

        if (len % 2 == 0) {
            int a = findKthLargest(A, 0, B, 0, len / 2);
            int b = findKthLargest(A, 0, B, 0, len / 2 + 1);
            return (a + b) / 2.0;
        } else {
            return (double) findKthLargest(A, 0, B, 0, len / 2 + 1);
        }


    }

    private int findKthLargest(int[] A, int startA, int[] B, int startB, int k) {

        // exit of recursion
        if (startA >= A.length) {
            return B[startB + k - 1];
        }

        if (startB >= B.length) {
            return A[startA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        if (k / 2 > A.length - startA) {
            return findKthLargest(A, startA, B, startB + k / 2, k - k / 2);
        } else if (k / 2 > B.length) {
            return findKthLargest(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            int halfKA = A[startA + k / 2 - 1];
            int halfKB = B[startB + k / 2 - 1];
            if (halfKA < halfKB) {
                return findKthLargest(A, startA + k / 2, B, startB, k - k / 2);
            } else {
                return findKthLargest(A, startA, B, startB + k / 2, k - k / 2);
            }
        }
    }
}
