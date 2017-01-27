/**
 * <h1>186. Reverse Words in a String II</h1>
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * <p>
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * <p>
 * Could you do it in-place without allocating extra space?
 *
 * @author Jerry
 * @since 1/26/17
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        reverseBetween(s, 0, s.length - 1);
        int ind = 0;
        while (ind < s.length) {
            int space = ind;
            while (space < s.length && s[space] != ' ') {
                space++;
            }
            reverseBetween(s, ind, space - 1);
            ind = space + 1;
        }
    }

    private void reverseBetween(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}
