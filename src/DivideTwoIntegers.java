/**
 * <h1>29. Divide Two Integers</h1>
 * Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.
 *
 * @author Jerry
 * @since 8/21/16
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int quotient = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            quotient += 1 << (shift - 1);
            a -= b << (shift - 1);
        }
        return isNegative ? -quotient : quotient;
    }
}
