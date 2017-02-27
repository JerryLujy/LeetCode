/**
 * <h1>343. Integer Break</h1>
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * @author Jerry
 * @since 2/26/17
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        return ans * n;
    }
}
