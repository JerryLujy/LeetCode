/**
 * <h1>201. Bitwise AND of Numbers Range</h1>
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * <p>
 * For example, given the range [5, 7], you should return 4.
 *
 * @author Jerry
 * @since 1/27/17
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int move = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            move++;
        }
        return m << move;
    }
}
