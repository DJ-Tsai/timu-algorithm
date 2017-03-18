package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dj on 1/12/17.
 */
public class AmicablePair_243_E {
    /**
     * @param k an integer
     * @return all amicable pairs
     */
    public List<List<Integer>> amicablePair(int k) {
        List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
        for (int i = 2; i <= k; i++){
            int amicable = getDivisorSum(i);
            if(amicable <= i || amicable > k){
                continue;
            }
            if(getDivisorSum(amicable) == i){
                ArrayList<Integer> pair = new ArrayList<Integer>(2);
                pair.add(i);
                pair.add(amicable);
                listOfList.add(pair);
            }

        }
        return listOfList;

    }

    private int getDivisorSum(int num){
        int sum = 1;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0){
                if (num / i != i){
                    sum = sum + i + num / i;
                }else {
                    sum = sum + i;
                }
            }
        }
        return sum;
    }
}
