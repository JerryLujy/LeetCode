import java.util.ArrayList;
import java.util.List;

/**
 * <h1>282. Expression Add Operators</h1>
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * <p>
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"],
 * "232", 8 -> ["2*3+2", "2+3*2"],
 * "105", 5 -> ["1*0+5","10-5"],
 * "00", 0 -> ["0+0", "0-0", "0*0"],
 * "3456237490", 9191 -> []
 *
 * @author Jerry
 * @since 2/10/17
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= num.length(); i++) {
            if (i > 1 && num.charAt(0) == '0') {
                break;
            }
            String sub = num.substring(0, i);
            addOperators(ans, sub, num, i, target, 0, Long.parseLong(sub));
        }
        return ans;
    }

    private void addOperators(List<String> ans, String expr, String num, int ind, int target, long sum, long mult) {
        if (ind == num.length()) {
            if (sum + mult == target) {
                ans.add(expr);
            }
            return;
        }
        for (int i = ind + 1; i <= num.length(); i++) {
            if (i > ind + 1 && num.charAt(ind) == '0') {
                break;
            }
            long curr = Long.parseLong(num.substring(ind, i));
            addOperators(ans, expr + "+" + curr, num, i, target, sum + mult, curr);
            addOperators(ans, expr + "-" + curr, num, i, target, sum + mult, -curr);
            addOperators(ans, expr + "*" + curr, num, i, target, sum, mult * curr);
        }
    }
}
