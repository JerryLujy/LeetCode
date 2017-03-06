/**
 * <h1>370. Range Addition</h1>
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 * <p>
 * Example: Given: length = 5, updates = [[1,  3,  2],[2,  4,  3],[0,  2, -2]], Output: [-2, 0, 3, 5, 3]
 * <p>
 * Explanation: Initial state: [ 0, 0, 0, 0, 0 ]
 * <p>
 * After applying operation [1, 3, 2]: [ 0, 2, 2, 2, 0 ]
 * <p>
 * After applying operation [2, 4, 3]: [ 0, 2, 5, 5, 3 ]
 * <p>
 * After applying operation [0, 2, -2]: [-2, 0, 3, 5, 3 ]
 *
 * @author Jerry
 * @since 3/5/17
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates) {
            ans[update[0]] += update[2];
            if (update[1] + 1 < length) {
                ans[update[1] + 1] -= update[2];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += ans[i];
            ans[i] = sum;
        }
        return ans;
    }
}
