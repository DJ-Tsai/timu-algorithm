package org.dongjian.jiuzhang.algorithm.easy;

/**
 * A=[1,2,3,4]
 * <p>
 * B=[2,4,5,6]
 * <p>e
 * return [1,2,2,3,4,4,5,6]
 */
public class MergeTwoSortedArray_6_E {
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int[] result = new int[A.length + B.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (k < result.length) {
            if (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    result[k++] = A[i++];
                } else {
                    result[k++] = B[j++];
                }
            } else if (i >= A.length) {
                result[k++] = B[j++];
            } else {
                result[k++] = A[i++];
            }
        }

        return result;
    }
}
