/**
 * <h1>357. Count Numbers with Unique Digits</h1>
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 <= x < 10^n.
 * <p>
 * Example: Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding [11,22,33,44,55,66,77,88,99])
 *
 * @author Jerry
 * @since 2/28/17
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, choices = 9;
        // 2 digits: 9 * 9 choices
        // 3 digits: 9 * 9 * 8 choices
        // 4 digits: 9 * 9 * 8 * 7 choices, and so on
        for (int i = 2; i <= Math.min(n, 10); i++) {
            choices *= 11 - i;
            ans += choices;
        }
        return ans;
    }
}
