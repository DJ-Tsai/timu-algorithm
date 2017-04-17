package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Cosine similarity is a measure of similarity between two vectors of an inner product space that measures the cosine of the angle between them. The cosine of 0° is 1, and it is less than 1 for any other angle.
 * <p>
 * See wiki: Cosine Similarity
 * <p>
 * Example
 * Given A = [1, 2, 3], B = [2, 3 ,4].
 * <p>
 * Return 0.9926.
 * <p>
 * Given A = [0], B = [0].
 * <p>
 * Return 2.0000
 */
public class CosineSimilarity_445_E {
    public double cosineSimilarity(int[] A, int[] B) {
        int dividor = 0;
        for (int i = 0; i < A.length; i++) {
            dividor += A[i] * B[i];
        }

        int dividenA = 0;
        for (int i = 0; i < A.length; i++) {
            dividenA += A[i] * A[i];
        }
        if (dividenA == 0) {
            return 2;
        }

        int dividenB = 0;
        for (int i = 0; i < B.length; i++) {
            dividenB += B[i] * B[i];
        }

        if (dividenB == 0) {
            return 2;
        }

        return dividor / Math.sqrt(dividenA) / Math.sqrt(dividenB);
    }
}
