package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/9/17.
 */
public class MaxOf3Number_283_N {

    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
