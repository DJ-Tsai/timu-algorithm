package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Partition an unsorted integer array into three parts:
 * <p>
 * The front part < low
 * The middle part >= low & <= high
 * The tail part > high
 * Return any of the possible solutions.
 * <p>
 * Notice
 * <p>
 * low <= high in all testcases.
 * <p>
 * Example
 * Given [4,3,4,1,2,3,1,2], and low = 2 and high = 3.
 * <p>
 * Change to [1,1,2,3,2,3,4,4].
 * <p>
 * ([1,1,2,2,3,3,4,4] is also a correct answer, but [1,2,1,2,3,3,4,4] is not)
 */
public class PatitionArrayII_625_M {
    public void partition2(int[] nums, int low, int high) {
        // all numbers before p1 should be < low
        int p1 = 0;
        // all numbers after p2 should be > high
        int p2 = nums.length - 1;

        int index = 0;

        while (index <= p2) {
            if (nums[index] < low) {
                // num on p1 can be guaranteed less than high and greater than low, so index can increment by 1
                swap(nums, index++, p1++);
            } else if (nums[index] > high) {
                // num on p2 can not be guaranteed its range, after swap, num on index need to be checked again, so index cannot increment by 1.
                swap(nums, index, p2--);
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
