/**
 * <h1>342. Power of Four</h1>
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example: Given num = 16, return true. Given num = 5, return false.
 *
 * @author Jerry
 * @since 2/26/17
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
