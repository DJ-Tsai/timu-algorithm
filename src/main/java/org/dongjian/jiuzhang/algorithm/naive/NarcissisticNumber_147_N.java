package org.dongjian.jiuzhang.algorithm.naive;

import java.util.ArrayList;

/**
 * Created by Dj on 1/12/17.
 */
public class NarcissisticNumber_147_N {
    /*
     * @param n: The number of digits.
     * @return: All narcissistic numbers with n digits.
     */
    public ArrayList<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        int startIndex, endIndex;
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n == 1){
            startIndex = 0;
            endIndex = 10;
        }else{
            startIndex = (int)Math.pow(10, n - 1);
            endIndex = Math.pow(10, n) < Integer.MAX_VALUE ? (int)Math.pow(10,n):Integer.MAX_VALUE;
        }

        for (int i = startIndex; i < endIndex; i++) {
            if (i == getNarcissistic(i, n)) {
                result.add(i);
            }
        }
        return result;
    }

    private int getNarcissistic(int num, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + (int)Math.pow(num % 10, n);
            num = num / 10;
        }
        return sum;
    }
}
