/**
 * <h1>338. Counting Bits</h1>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 *
 * @author Jerry
 * @since 2/26/17
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i <<= 1) {
            for (int n = 0; n < i && i + n <= num; n++) {
                ans[i + n] = 1 + ans[n];
            }
        }
        return ans;
    }
}
