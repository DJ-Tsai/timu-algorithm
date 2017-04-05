package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Find the kth smallest numbers in an unsorted integer array.
 * <p>
 * Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are 3.
 * <p>
 * Challenge:
 * An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.
 */
public class KthSmallestNumbersInUnsortedArray_461_M {
    public int kthSmallest(int k, int[] nums) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[start];
        }
        int i = start;
        int j = end;
        int pivot = nums[(start + end) / 2];

        while (i <= j) {


            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(nums, i++, j--);
            }
        }

        if (j - start + 1 >= k) {
            // System.out.println(start +" " + j +""+ k);
            return quickSelect(nums, start, j, k);

        } else if (i - start < k) {
            // System.out.println(i +" " + end );
            return quickSelect(nums, i, end, k - (i - start));

        } else {
            return nums[i - 1];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
