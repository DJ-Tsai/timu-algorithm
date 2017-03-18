package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/11/17.
 */
public class SwapTwoIntegersInArray_484_N {
    public void swapIntegers(int[] A, int index1, int index2) {
        // Write your code here
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}
