package org.dongjian.jiuzhang.algorithm.hard;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * [
 * "0010",
 * "0110",
 * "0100"
 * ]
 * <p>
 * and x = 0, y = 2,
 * Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels_600_H {
    public int minArea(char[][] image, int x, int y) {
        if (null == image) {
            return -1;
        }

        int up, down, left, right;
        int start, end;

        // leftUp
        start = 0;
        end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackOnRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (hasBlackOnRow(image, start)) {
            up = start;
        } else {
            up = end;
        }


        // down
        start = x;
        end = image.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackOnRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (hasBlackOnRow(image, end)) {
            down = end;
        } else {
            down = start;
        }

        //left
        start = 0;
        end = y;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackOnCol(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (hasBlackOnCol(image, start)) {
            left = start;
        } else {
            left = end;
        }

        // right
        start = y;
        end = image[0].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlackOnCol(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (hasBlackOnCol(image, end)) {
            right = end;
        } else {
            right = start;
        }

        return (down - up + 1) * (right - left + 1);
    }

    private boolean hasBlackOnCol(char[][] image, int col) {
        int rowNum = image.length;
        for (int i = 0; i < rowNum; i++) {
            if (image[i][col] == '1') {
                return true;
            }
        }

        return false;
    }

    private boolean hasBlackOnRow(char[][] image, int row) {

        for (char c : image[row]) {
            if (c == '1') {
                return true;
            }
        }

        return false;
    }
}
