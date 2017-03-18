package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Created by Dj on 3/11/17.
 */
public class FirstBadVersion_74_M {
    public int findFirstBadVersion(int n) {
        if (SVNRepo.isBadVersion(1)) {
            return 1;
        }

        // if (!SVNRepo.isBadVersion(n)) {
        //     return -1;
        // }

        int start = 0;
        int end = n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }

        return end;
    }

    static class SVNRepo {
        public static boolean isBadVersion(int n) {
            return true;
        }
    }
}
