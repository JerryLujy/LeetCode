/**
 * <h1>233. Number of Digit One</h1>
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * <p>
 * For example: Given n = 13, Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 *
 * @author Jerry
 * @since 2/2/17
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        long ans = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            ans += a / 10 * m;
            ans += (a % 10 > 1) ? m : 0;
            ans += (a % 10 == 1) ? b + 1 : 0;
        }
        return (int) ans;
    }
}
