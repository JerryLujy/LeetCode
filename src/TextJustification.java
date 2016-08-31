import java.util.ArrayList;
import java.util.List;

/**
 * <h1>68. Text Justification</h1>
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * For example, words: ["This", "is", "an", "example", "of", "text", "justification."], L: 16.
 * Return the formatted lines as:
 * <p>
 * ["This    is    an",
 * <p>
 * "example  of text",
 * <p>
 * "justification.  "]
 * <p>
 * Note: Each word is guaranteed not to exceed L in length. A line other than the last line might contain only one word.
 * In this case, that line should be left-justified.
 *
 * @author Jerry
 * @since 8/30/16
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add(words[0]);
        int curWidth = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (curWidth + words[i].length() + 1 <= maxWidth) {
                list.add(words[i]);
                curWidth += words[i].length() + 1;
            } else {
                ans.add(format(list, maxWidth));
                list.clear();
                list.add(words[i]);
                curWidth = words[i].length();
            }
        }
        // Last line
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s).append(' ');
        if (sb.length() > maxWidth) {
            sb.delete(maxWidth, sb.length());
        } else {
            printSpace(sb, maxWidth - sb.length());
        }
        ans.add(sb.toString());
        return ans;
    }

    private String format(List<String> l, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int totalSpace = maxWidth;
        for (String s : l) {
            totalSpace -= s.length();
        }
        sb.append(l.get(0));
        if (l.size() == 1) {
            printSpace(sb, totalSpace);
            return sb.toString();
        }

        int numSpace = totalSpace / (l.size() - 1);
        int remainUntil = totalSpace % (l.size() - 1);
        for (int i = 1; i < l.size(); i++) {
            printSpace(sb, numSpace + (i <= remainUntil ? 1 : 0));
            sb.append(l.get(i));
        }
        return sb.toString();
    }

    private void printSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
    }
}
