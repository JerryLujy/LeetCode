import java.util.Arrays;

/**
 * <h1>935. Knight Dialer</h1>
 * A chess knight can move as indicated in the chess diagram below.
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.
 * Each hop must be from one key to another numbered key.
 * Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.
 * How many distinct numbers can you dial in this manner?
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 * <p>
 * Example 1: Input: 1, Output: 10
 * <p>
 * Example 2: Input: 2, Output: 20
 * <p>
 * Example 3: Input: 3, Output: 46
 * <p>
 * Note:
 * 1 <= N <= 5000
 *
 * @author Jerry
 * @since 2/4/19
 */
public class KnightDialer {
    public int knightDialer(int N) {
        long mod = 1_000_000_007;
        long[] mem = new long[10];
        Arrays.fill(mem, 1L);
        while (--N > 0) {
            long n1 = (mem[8] + mem[6]) % mod;
            long n2 = (mem[7] + mem[9]) % mod;
            long n3 = (mem[4] + mem[8]) % mod;
            long n4 = (mem[0] + mem[9] + mem[3]) % mod;
            long n6 = (mem[0] + mem[1] + mem[7]) % mod;
            long n7 = (mem[2] + mem[6]) % mod;
            long n8 = (mem[1] + mem[3]) % mod;
            long n9 = (mem[2] + mem[4]) % mod;
            long n0 = (mem[4] + mem[6]) % mod;
            mem[0] = n0;mem[1] = n1;mem[2] = n2;mem[3] = n3;mem[4] = n4;
            mem[5] = 0;mem[6] = n6;mem[7] = n7;mem[8] = n8;mem[9] = n9;
        }
        return (int)(Arrays.stream(mem).sum() % mod);
    }
}
