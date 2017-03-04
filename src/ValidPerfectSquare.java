/**
 * <h1>367. Valid Perfect Square</h1>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 *
 * @author Jerry
 * @since 3/3/17
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l <= r) {
            long mid = (l + r) >>> 1, sqr = mid * mid;
            if (sqr == num) {
                return true;
            } else if (sqr > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
