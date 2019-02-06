/**
 * <h1>941. Valid Mountain Array</h1>
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * Recall that A is a mountain array if and only if:
 * 1. A.length >= 3
 * 2. There exists some i with 0 < i < A.length - 1 such that:
 *    A[0] < A[1] < ... A[i-1] < A[i]
 *    A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * Example 1: Input: [2,1], Output: false
 * <p>
 * Example 2: Input: [3,5,5], Output: false
 * <p>
 * Example 3: Input: [0,3,2,1], Output: true
 * <p>
 * Note:
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author Jerry
 * @since 2/5/19
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        while (i < A.length - 2 && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0) {
            return false;
        }
        while (i < A.length - 1) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
