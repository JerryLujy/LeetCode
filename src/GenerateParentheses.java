import java.util.ArrayList;
import java.util.List;

/**
 * <h1>22. Generate Parentheses</h1>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author Jerry
 * @since 8/6/16
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        addParen(ans, sb, n, n);
        return ans;
    }

    private void addParen(List<String> l, StringBuilder sb, int lp, int rp) {
        if (lp == 0 && rp == 0) {
            l.add(sb.toString());
            return;
        }
        if (lp > 0) {
            sb.append('(');
            addParen(l, sb, lp - 1, rp);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rp > lp) {
            sb.append(')');
            addParen(l, sb, lp, rp - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
