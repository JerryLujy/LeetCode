/**
 * <h1>390. Elimination Game</h1>
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example: Input: n = 9,
 * <pre>
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * </pre>
 * Output: 6
 *
 * @author Jerry
 * @since 3/6/17
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        int head = 1, remain = n, step = 1;
        boolean l2r = true;
        while (remain > 1) {
            if (l2r || remain % 2 == 1) {
                head += step;
            }
            step <<= 1;
            remain >>= 1;
            l2r = !l2r;
        }
        return head;
    }
}
