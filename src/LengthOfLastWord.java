/**
 * <h1>58. Length of Last Word</h1>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * For example, Given s = "Hello World", return 5.
 *
 * @author Jerry
 * @since 8/28/16
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpace = s.lastIndexOf(' ');
        return s.length() - 1 - lastSpace;
    }
}
