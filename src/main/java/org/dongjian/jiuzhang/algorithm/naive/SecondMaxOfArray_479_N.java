package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/9/17.
 */
public class SecondMaxOfArray_479_N {

    public int secondMax(int[] nums) {
        int max1 = nums[0];
        int max2 = nums[1];

        for (int i = 2; i< nums.length;i++){
            if (nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
            }else if (nums[i] > max2){
                max2 = nums[i];
            }

        }
        return max2;
    }
}
