package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;

/**
 * Given an integers array A.
 * <p>
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
 * <p>
 * Example
 * For A = [1, 2, 3], return [6, 3, 2].
 */
public class ProductOfArrayExcludeItself_50_E {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> res = new ArrayList<Long>();

        for (int i = 0; i < A.size(); i++) {
            long prod = 1;
            for (int j = 0; j < A.size(); j++) {
                if (j == i) {
                    continue;
                }

                prod = prod * A.get(j);
            }
            res.add(prod);
        }

        return res;
    }
}
