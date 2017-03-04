import java.util.TreeSet;

/**
 * <h1>363. Max Sum of Rectangle No Larger Than K</h1>
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 * <p>
 * Example: Given matrix =
 * <pre>
 * [[1,  0, 1],
 * [0, -2, 3]]
 * </pre>
 * k = 2, The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
 * <p>
 * Note:
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 *
 * @author Jerry
 * @since 3/4/17
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int c1 = 0; c1 < n; c1++) {
            int[] rowSum = new int[m];
            for (int c2 = c1; c2 < n; c2++) {
                for (int r = 0; r < m; r++) {
                    rowSum[r] += matrix[r][c2];
                }
                ans = Math.max(ans, maxSumSubArray(rowSum, k));
            }
        }
        return ans;
    }

    private int maxSumSubArray(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            Integer target = set.ceiling(sum - k);
            if (target != null) { // Found a target such that sum - target <= k
                maxSum = Integer.max(maxSum, sum - target);
            }
            set.add(sum);
        }
        return maxSum;
    }
}
