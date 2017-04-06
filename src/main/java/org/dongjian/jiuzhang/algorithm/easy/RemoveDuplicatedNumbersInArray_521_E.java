package org.dongjian.jiuzhang.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dj on 1/9/17.
 */
public class RemoveDuplicatedNumbersInArray_521_E {
    public int deduplication(int[] nums) {
        // Write your code here
        HashMap<Integer, Boolean> map = new HashMap();

        // Time complexity O(n)
        for (int i = 0; i<nums.length;i++ ) {
            map.put(nums[i],true);
        }

        int result = 0;
        // Time complexity O(n)
        for (Map.Entry<Integer,Boolean> entry : map.entrySet()) {
            nums[result++] = entry.getKey();
        }

        return result;
    }

}
