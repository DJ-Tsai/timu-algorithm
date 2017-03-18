package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Dj on 1/30/17.
 */
public class SubArraySum_138_E {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        Hashtable<Integer,Integer> table = new Hashtable();

        // sum = 0, index = -1;
        int sum = 0;
        table.put(sum,-1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(table.containsKey(sum)) {
                result.add(table.get(sum) + 1);
                result.add(i);
                return result;
            }

            table.put(sum,i);
        }

        return result;
    }
}
