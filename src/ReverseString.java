/**
 * <h1>344. Reverse String</h1>
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example: Given s = "hello", return "olleh".
 *
 * @author Jerry
 * @since 2/26/17
 */
public class ReverseString {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
