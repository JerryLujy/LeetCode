/**
 * <h1>977. Squares of a Sorted Array</h1>
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * Example 1: Input: [-4,-1,0,3,10], Output: [0,1,9,16,100]
 * <p>
 * Example 2: Input: [-7,-3,2,3,11], Output: [4,9,9,49,121]
 * <p>
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 *
 * @author Jerry
 * @since 2/5/19
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int j = 0;
        while (j < A.length && A[j] < 0) {
            j++;
        }
        int i = j - 1;
        int[] ans = new int[A.length];
        int ind = 0;
        while (i >= 0 && j < A.length) {
            if (Math.abs(A[i]) <= Math.abs(A[j])) {
                ans[ind++] = A[i] * A[i];
                i--;
            } else {
                ans[ind++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            ans[ind++] = A[i] * A[i];
            i--;
        }
        while (j < A.length) {
            ans[ind++] = A[j] * A[j];
            j++;
        }
        return ans;
    }
}
