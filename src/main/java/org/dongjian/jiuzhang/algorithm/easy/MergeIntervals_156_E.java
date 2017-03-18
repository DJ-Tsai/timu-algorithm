package org.dongjian.jiuzhang.algorithm.easy;

import com.faith.dj.jiuzhang.java.fundamental.common.Interval;

import java.util.Collections;
import java.util.List;

/**
 * Created by Dj on 2/4/17.
 */
public class MergeIntervals_156_E {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size() == 1) {
            return intervals;
        }
        Interval temp = new Interval(0,0);
        sort(intervals, 0, intervals.size() - 1);

        int i = 0;
        while (i < intervals.size() - 1) {
            Interval first = intervals.get(i);
            Interval second = intervals.get(i + 1);

            while (first.end >= second.start) {
                first.end = Math.max(first.end,second.end);
                first.start = Math.min(first.start,second.start);

                intervals.remove(i + 1);
                if (i < intervals.size() -1) {
                    second = intervals.get(i + 1);
                } else {
                    return intervals;
                }
            }
            i++;
        }

        return intervals;
    }

    private void sort(List<Interval> intervals, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int mid = intervals.get(left + (right - left)/2).start;

        while (i <= j) {
            while (i <= j && intervals.get(i).start < mid) {
                i++;
            }

            while (i <= j && intervals.get(j).start > mid) {
                j--;
            }

            if (i <= j) {
                Collections.swap(intervals, i++, j--);
            }
        }

        sort(intervals, left, j);
        sort(intervals, i, right);
    }
}
