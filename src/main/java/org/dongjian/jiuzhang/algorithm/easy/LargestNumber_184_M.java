package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * [1, 20, 23, 4, 8] -> 8423201
 */
public class LargestNumber_184_M {
    public String largestNumber(int[] num) {
        // write your code here
        String[] strings = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strings[i] = Integer.toString(num[i]);
        }

        sort(strings, 0, strings.length - 1);

        return print(strings);

    }

    private void sort(String[] sArray, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        String pivot = sArray[left + (right - left) / 2];

        while (i <= j) {
            while (i <= j && isFirstLarger(sArray[i], pivot)) {
                i++;
            }

            while (i <= j && isFirstSmaller(sArray[j], pivot)) {
                j--;
            }

            if (i <= j ) {
                String temp = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = temp;
                i++;
                j--;
            }
        }

        sort(sArray, left, j);
        sort(sArray, i, right);
    }

    private boolean isFirstLarger(String first, String second) {
        String firstSecond = first + second;
        String secondFirst = second + first;
        if (firstSecond.compareTo(secondFirst) > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFirstSmaller(String first, String second) {
        String firstSecond = first + second;
        String secondFirst = second + first;
        if (firstSecond.compareTo(secondFirst) < 0) {
            return true;
        } else {
            return false;
        }
    }

    private String print(String[] arrays) {
        if (arrays[0].equals("0") && arrays[arrays.length - 1].equals("0")) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arrays.length; i++) {
            builder.append(arrays[i]);
        }
        return builder.toString();
    }
}
