package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.
 */
public class SortInteger_463_E {
    public void sortIntegers(int[] A) {
        /*
         Bubble Sorting
          */
        // for (int i = 1; i < A.length; i++) {
        //     for (int j = 1; j < A.length; j++) {
        //         if (A[j] < A[j-1]) {
        //             int temp = A[j];
        //             A[j] = A[j-1];
        //             A[j-1] = temp;
        //         }
        //     }
        // }

        /*
         Selection Sorting
          */
        // for (int i = 0; i < A.length - 1; i++) {
        //     int smallestIndex = i;
        //     for (int j = i + 1; j < A.length; j++) {
        //         if (A[j] < A[i]) {
        //             smallestIndex = j;
        //         }
        //     }
        //     if (smallestIndex != i) {
        //         int temp = A[i];
        //         A[i] = A[smallestIndex];
        //         A[smallestIndex] = temp;
        //     }
        // }

        /*
        Insertion Sorting
         */
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > temp) {
                A[j + 1] = A[j--];
            }
            A[j + 1] = temp;
        }
    }
}
