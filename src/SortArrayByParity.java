/**
 * <h1>905. Sort Array By Parity</h1>
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * <p>
 * Example 1: Input: [3,1,2,4], Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * @author Jerry
 * @since 2/4/19
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (i < j && A[i] % 2 == 0) i++;
            while (i < j && A[j] % 2 == 1) j--;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }
}
