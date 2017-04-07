package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.
 * <p>
 * Example
 * Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]
 * <p>
 * Return
 */
public class HighFive_613_M {
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> res = new HashMap<Integer, Double>();
        Map<Integer, List<Integer>> recordMap = new HashMap<Integer, List<Integer>>();

        // loop through
        for (Record r : results) {
            if (!recordMap.containsKey(r.id)) {
                recordMap.put(r.id, new ArrayList<Integer>());
            }

            if (recordMap.get(r.id).size() < 5) {
                recordMap.get(r.id).add(r.score);
            } else {
                int smallInd = 0;

                // find smallest score
                for (int i = 1; i < 5; i++) {
                    if (recordMap.get(r.id).get(i) < recordMap.get(r.id).get(smallInd)) {
                        smallInd = i;
                    }
                }

                // compare the smallest with the new score save the larger one
                if (r.score > recordMap.get(r.id).get(smallInd)) {
                    recordMap.get(r.id).set(smallInd, r.score);
                }
            }
        }

        for (Integer id : recordMap.keySet()) {
            int sum = 0;
            for (Integer score : recordMap.get(id)) {
                sum = sum + score;
            }

            res.put(id, sum / 5.0);
        }

        return res;
    }

    private class Record {
        public int id, score;

        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
