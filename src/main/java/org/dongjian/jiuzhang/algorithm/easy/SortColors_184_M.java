package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Created by Dj on 2/5/17.
 */
public class SortColors_184_M {
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }

        int p1 = 0;
        int p2 = nums.length - 1;
        int i = 0;

        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p1);
                i++;
                p1++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
