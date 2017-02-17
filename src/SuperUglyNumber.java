/**
 * <h1>313. Super Ugly Number</h1>
 * Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * <p>
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k <= 100, 0 < n <= 10^6, 0 < primes[i] < 1000.
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 * @author Jerry
 * @since 2/16/17
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] mem = new int[n];
        mem[0] = 1;
        int[] ind = new int[primes.length];
        for (int i = 1; i < n; i++) {
            mem[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                mem[i] = Math.min(mem[i], primes[j] * mem[ind[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * mem[ind[j]] == mem[i]) {
                    ind[j]++;
                }
            }
        }
        return mem[n - 1];
    }
}
