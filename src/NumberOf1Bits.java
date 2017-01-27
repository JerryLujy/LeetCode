/**
 * <h1>191. Number of 1 Bits</h1>
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * @author Jerry
 * @since 1/26/17
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ans++;
        }
        return ans;
    }
}
