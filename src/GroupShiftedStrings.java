import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>249. Group Shifted Strings</h1>
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
 * <p>
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * <p>
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], A solution is:
 * [["abc","bcd","xyz"],["az","ba"],["acef"],["a","z"]]
 *
 * @author Jerry
 * @since 2/4/17
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strings) {
            String normalized = normalize(s);
            if (!groups.containsKey(normalized)) {
                groups.put(normalized, new ArrayList<>());
            }
            groups.get(normalized).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> l : groups.values()) {
            ans.add(l);
        }
        return ans;
    }

    private String normalize(String s) {
        int offset = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char newChar = (char) (sb.charAt(i) - offset);
            if (newChar < 'a') {
                newChar += 26;
            }
            sb.setCharAt(i, newChar);
        }
        return sb.toString();
    }
}
