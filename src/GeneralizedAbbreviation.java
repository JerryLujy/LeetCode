import java.util.ArrayList;
import java.util.List;

/**
 * <h1>320. Generalized Abbreviation</h1>
 * Write a function to generate the generalized abbreviations of a word.
 * <p>
 * Example: Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * @author Jerry
 * @since 2/23/17
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        generate(word, 0, ans, new StringBuilder());
        return ans;
    }

    private void generate(String s, int count, List<String> ans, StringBuilder sb) {
        int originalLen = sb.length();
        if (s.isEmpty()) {
            if (count > 0) {
                sb.append(count);
            }
            ans.add(sb.toString());
        } else {
            generate(s.substring(1), count + 1, ans, sb); // Abbreviate this char
            // Do not abbreviate this char
            if (count > 0) {
                sb.append(count);
            }
            sb.append(s.charAt(0));
            generate(s.substring(1), 0, ans, sb);
        }
        sb.setLength(originalLen);
    }
}
