/**
 * <h1>50. Pow(x, n)</h1>
 * Implement pow(x, n).
 *
 * @author Jerry
 * @since 8/27/16
 */
public class Pow_x_n {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return 1.0 / x / myPow(x, Integer.MAX_VALUE);
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }
        double tmp = myPow(x, n / 2);
        return tmp * tmp;
    }
}
