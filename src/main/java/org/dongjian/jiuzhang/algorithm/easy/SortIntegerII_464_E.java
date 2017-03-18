package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
 */
public class SortIntegerII_464_E {


    public void sortIntegers2(int[] A) {
        // Write your code here
        sortHelper(A, 0, A.length-1);

    }

    private void sortHelper(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = a[(left + right)/2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (a[i] < pivot && i < j) {
                i++;
            }
            while (a[j] > pivot && j > i) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        sortHelper(a, left, j);
        sortHelper(a, i, right);
    }

    /*
    Enhanced version
     */
    private void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int pivot = a[left + (right - left) / 2];

        while (i <= j) {
            while (i <= j && a[i] < pivot) {
                i++;
            }

            while (i <= j && a[j] > pivot) {
                j--;
            }

            while(i <= j) {
                swap(a, i++, j--);
            }
        }

        quickSort(a, left, j);
        quickSort(a, i, right);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
