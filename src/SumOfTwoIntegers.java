/**
 * <h1>371. Sum of Two Integers</h1>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * @author Jerry
 * @since 3/5/17
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }
}
