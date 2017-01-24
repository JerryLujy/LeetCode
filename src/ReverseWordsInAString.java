/**
 * <h1>151. Reverse Words in a String</h1>
 * Given an input string, reverse the string word by word.
 * <p>
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * <p>
 * Clarifications:
 * A sequence of non-space characters constitutes a word.
 * Input string can contain leading or trailing spaces. However, reversed string should not contain leading or trailing spaces.
 * Reduce multiple spaces between two words to a single space in the reversed string.
 *
 * @author Jerry
 * @since 1/23/17
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] tokens = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i > 0; i--) {
            sb.append(tokens[i]).append(" ");
        }
        sb.append(tokens[0]);
        return sb.toString();
    }
}
