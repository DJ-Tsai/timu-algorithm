package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/9/17.
 */
public class MaxOfArray_214_N {
    public float maxOfArray(float[] A) {
        // Write your code here
        float max = A[0];
        for (int i = 1; i < A.length; i++) {
            max = max > A[i] ? max : A[i];
        }
        return max;
    }
}
