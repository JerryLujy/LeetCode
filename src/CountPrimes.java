/**
 * <h1>204. Count Primes</h1>
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * @author Jerry
 * @since 1/27/17
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }
        return count;
    }
}
