/**
 * <h1>69. Sqrt(x)</h1>
 * Implement int sqrt(int x). Compute and return the square root of x.
 *
 * @author Jerry
 * @since 8/30/16
 */
public class Sqrt_x {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long lo = 1;
        long hi = x;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (lo * lo <= x) {
            return (int) lo;
        } else {
            return (int) hi;
        }
    }
}
