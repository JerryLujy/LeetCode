/**
 * <h1>7. Reverse Integer</h1>
 * Reverse digits of an integer. Function returns 0 when the reversed integer overflows.
 * <p>
 * Example1: x = 123, return 321
 * <p>
 * Example2: x = -123, return -321
 *
 * @author Jerry
 * @since 6/8/16
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int absx = Math.abs(x);
        int ans = 0;
        while (absx > 0) {
            if ((Integer.MAX_VALUE - absx % 10) / 10 < ans) {// Will overflow
                return 0;
            }
            ans = ans * 10 + absx % 10;
            absx /= 10;
        }
        return x > 0 ? ans : -ans;
    }
}
