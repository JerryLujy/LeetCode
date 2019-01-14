/**
 * <h1>400. Nth Digit</h1>
 * Find the n-th digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p>
 * Note: n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 * <p>
 * Example 1: Input: 3, Output: 3
 * <p>
 * Example 2: Input: 11, Output: 0
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 * @author Jerry
 * @since 1/14/19
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int numDigits = 1;
        long tenToThePowerOf = 1;
        while (n > numDigits * 9 * tenToThePowerOf) {
            n -= numDigits * 9 * tenToThePowerOf;
            numDigits++;
            tenToThePowerOf *= 10;
        }
        String num = String.valueOf((n - 1) / numDigits + tenToThePowerOf);
        return num.charAt((n - 1) % numDigits) - '0';
    }
}
