import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>17. Letter Combinations of a Phone Number</h1>
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author Jerry
 * @since 7/13/16
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return rst;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();
        buildList(rst, map, sb, digits);
        return rst;
    }

    private void buildList(List<String> l, Map<Character, char[]> m, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            l.add(sb.toString());
            return;
        }
        for (char c : m.get(digits.charAt(sb.length()))) {
            sb.append(c);
            buildList(l, m, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
