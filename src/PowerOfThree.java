/**
 * <h1>326. Power of Three</h1>
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Follow up: Could you do it without using any loop / recursion?
 *
 * @author Jerry
 * @since 2/24/17
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
