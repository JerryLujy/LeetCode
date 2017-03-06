/**
 * <h1>372. Super Pow</h1>
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 * Example1: a = 2, b = [3], Result: 8
 * <p>
 * Example2: a = 2, b = [1,0], Result: 1024
 *
 * @author Jerry
 * @since 3/5/17
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    private int superPow(int a, int[] b, int ind) {
        if (ind == -1) {
            return 1;
        }
        // a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
        return powmod(superPow(a, b, ind - 1), 10) * powmod(a, b[ind]) % 1337;
    }

    private int powmod(int a, int k) {
        // a^k mod 1337
        a %= 1337;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = (result * a) % 1337;
        }
        return result;
    }
}
