/**
 * <h1>845. Longest Mountain in Array</h1>
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 * 1. B.length >= 3
 * 2. There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 * <p>
 * Given an array A of integers, return the length of the longest mountain. Return 0 if there is no mountain.
 * <p>
 * Example 1: Input: [2,1,4,7,3,2,5], Output: 5, Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * <p>
 * Example 2: Input: [2,2,2], Output: 0, Explanation: There is no mountain.
 * <p>
 * Note:
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author Jerry
 * @since 2/1/19
 */
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        int i = 0;
        int ans = 0;
        while (i < A.length) {
            int j = i;
            while (j + 1 < A.length && A[j + 1] > A[j]) {
                j++;
            }
            if (j == i) {
                i++;
                continue;
            }
            int k = j;
            while (k + 1 < A.length && A[k + 1] < A[k]) {
                k++;
            }
            if (k > j) {
                ans = Math.max(ans, k - i + 1);
            }
            i = k;
        }
        return ans;
    }
}
