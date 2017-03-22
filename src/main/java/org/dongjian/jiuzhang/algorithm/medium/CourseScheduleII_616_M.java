package org.dongjian.jiuzhang.algorithm.medium;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example
 * Given n = 2, prerequisites = [[1,0]]
 * Return [0,1]
 * <p>
 * Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 * Return [0,1,2,3] or [0,2,1,3]
 */
public class CourseScheduleII_616_M {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();

        for (int i = 0; i < numCourses; ++i) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            indegree[prerequisites[i][0]] += 1;
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList();
        ArrayList<Integer> res = new ArrayList();

        // Be really careful on this part
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            Integer course = queue.remove();
            res.add(course);
            for (Integer i : map.get(course)) {
                indegree[i] -= 1;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[0];
        } else {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                result[i] = res.get(i);
            }
            return result;
        }
    }
}
