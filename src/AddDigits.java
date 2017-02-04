/**
 * <h1>258. Add Digits</h1>
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * @author Jerry
 * @since 2/4/17
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int num2 = num;
            num = 0;
            while (num2 > 0) {
                num += num2 % 10;
                num2 /= 10;
            }
        }
        return num;
    }
}
