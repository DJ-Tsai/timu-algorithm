package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Created by Dj on 2/5/17.
 */
public class SortColorsII_143_M {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int left = 0;
        int right = colors.length - 1;
        int colorMin = 1;
        int colorMax = k;

        while (colorMin < colorMax) {
            // int start = left;
            // int end = right;
            int current = left;

            while (current <= right) {
                if (colors[current] == colorMin) {
                    swap(colors, left, current);
                    left++;
                    current++;
                } else if (colors[current] == colorMax) {
                    swap(colors, right, current);
                    right--;
                } else {
                    current++;
                }
            }
            colorMin++;
            colorMax--;
        }
    }

    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
