package org.dongjian.jiuzhang.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Notice
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 * <p>
 * <p>
 * Example
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * <p>
 * Challenge
 * Can you implement it in three different algorithms?
 */
public class IntersectionOfTwoArrays_547_E {
    public int[] intersection(int[] nums1, int[] nums2) {
        // ------------------method 1

        Set<Integer> set = new HashSet();
        Set<Integer> res = new HashSet();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

        int[] result = new int[res.size()];
        int count = 0;
        for (Integer i : res) {
            result[count++] = i;
        }

        return result;

        // ---------------method 2 - sort and merge
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);

        // int i = 0;
        // int j = 0;

        // ArrayList<Integer> list = new ArrayList<>();

        // while (i < nums1.length && j < nums2.length) {
        //     if (nums1[i] == nums2[j]) {
        //         list.add(nums1[i]);
        //         i++;
        //         while (i < nums1.length && nums1[i] == nums1[i - 1]) {
        //             i++;
        //         }
        //         j++;
        //         while (j < nums2.length && nums2[j] == nums2[j - 1]) {
        //             j++;
        //         }
        //     } else if (nums1[i] < nums2[j]) {
        //         i++;
        //         while (i < nums1.length && nums1[i] == nums1[i - 1]) {
        //             i++;
        //         }
        //     } else {
        //         j++;
        //         while (j < nums2.length && nums2[j] == nums2[j - 1]) {
        //             j++;
        //         }
        //     }
        // }

        // int[] res = new int[list.size()];
        // for (int k = 0; k < list.size(); k++) {
        //     res[k] = list.get(k);
        // }

        // return res;


        // method 3 - voilated
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // int[] res = new int[Math.min(nums1.length, nums2.length)];
        // int index = 0;

        // for (int i = 0; i < nums1.length; i++) {
        //     if (i != 0 && nums1[i] == nums1[i - 1]) {
        //         continue;
        //     }
        //     for (int j = 0; j < nums2.length; j++) {
        //         if (j == 0 || nums2[j] != nums2[j - 1]) {
        //             if (nums2[j] == nums1[i]) {
        //                 res[index++] = nums1[i];
        //                 break;
        //             }
        //         }
        //     }
        // }

        // return Arrays.copyOfRange(res, 0, index);
    }
}
