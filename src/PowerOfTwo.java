/**
 * <h1>231. Power of Two</h1>
 * Given an integer, write a function to determine if it is a power of two.
 *
 * @author Jerry
 * @since 2/1/17
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        int m = 1;
        for (int i = 16; i > 0; i >>= 1) {
            if (m == n) {
                return true;
            } else if (m < n) {
                m <<= i;
            } else {
                m >>= i;
            }
        }
        return m == n;
    }
}
