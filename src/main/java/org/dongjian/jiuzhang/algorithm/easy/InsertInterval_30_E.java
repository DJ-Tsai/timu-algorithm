package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.Interval;

import java.util.ArrayList;

/**
 * Given a non-overlapping interval list which is sorted by start point.
 * <p>
 * Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).
 * <p>
 * Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].
 * <p>
 * Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). You may assume that the intervals were initially sorted according to their start times. Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9]. Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]. This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval_30_E {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // write your code here

        if (newInterval == null) {
            return intervals;
        }

        ArrayList<Interval> result = new ArrayList<Interval>();

        if (intervals == null || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        int insertPosition = 0;

        for (Interval i : intervals) {
            if (i.end < newInterval.start) {
                result.add(i);
                insertPosition++;
            } else if (i.start > newInterval.end) {
                result.add(i);
            } else {
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(i.end, newInterval.end);
            }
        }
        result.add(insertPosition, newInterval);

        return result;
    }
}
