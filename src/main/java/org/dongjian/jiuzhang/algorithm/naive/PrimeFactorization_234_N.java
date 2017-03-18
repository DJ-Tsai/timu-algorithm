package org.dongjian.jiuzhang.algorithm.naive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dj on 1/11/17.
 */
public class PrimeFactorization_234_N {
    /**
     * @param num an integer
     * @return an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                list.add(i);
                num = num / i;
            }
        }
        if (num != 1) {
            list.add(num);
        }
        return list;
    }

}
