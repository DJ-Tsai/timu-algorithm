package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 * <p>
 * The order of elements can be changed, and the elements after the new length don't matter.
 * <p>
 * Example
 * Given an array [0,4,4,0,0,2,4,4], value=4
 * <p>
 * return 4 and front four elements of the array is [0,0,0,2]
 */
public class RemoveElement_172_E {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int left = 0, right = 0;

        while (right < A.length) {
            while (right < A.length && A[right] == elem) {
                right++;
            }

            if (right < A.length) {
                A[left] = A[right];
                left++;
                right++;
            }
        }

        return left;
    }
}
