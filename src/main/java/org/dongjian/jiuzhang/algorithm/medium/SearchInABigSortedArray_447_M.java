package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
 * Return -1, if the number doesn't exist in the array.
 *
 * If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.
 */
public class SearchInABigSortedArray_447_M {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        if (reader.get(0) > target) {
            return -1;
        }

        if (reader.get(0) == target) {
            return 0;
        }

        int index = 1;
        while (reader.get(index) < target) {
            index = index * 2;
        }

        if (reader.get(index) == 2147483647) {
            index = index / 2;
            while (reader.get(index) != 2147483647) {
                if (reader.get(index) < target) {
                    index++;
                } else if (reader.get(index) == target) {
                    return index;
                } else {
                    return -1;
                }
            }
            return -1;
        }

        int start = index / 2;
        int end = index;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else if (reader.get(mid) > target) {
                end = mid;
            } else {
                while (reader.get(mid) == target) {
                    mid--;
                }
                return mid + 1;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }

        if (reader.get(end) == target) {
            return end;
        }

        return -1;
    }

    class ArrayReader {
        public int get(int index) {
            return 1;
        }
    }

}
