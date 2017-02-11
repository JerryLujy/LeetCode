import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>288. Unique Word Abbreviation</h1>
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * <pre>
 * a) it                      --> it    (no abbreviation)
 *      1
 * b) d|o|g                   --> d1g
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * </pre>
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * <p>
 * isUnique("cart") -> true
 * <p>
 * isUnique("cane") -> false
 * <p>
 * isUnique("make") -> true
 *
 * @author Jerry
 * @since 2/11/17
 */
public class UniqueWordAbbreviation {
    private Map<String, Set<String>> map;

    public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String abbrev = toAbbrev(s);
            if (!map.containsKey(abbrev)) {
                map.put(abbrev, new HashSet<>());
            }
            map.get(abbrev).add(s);
        }
    }

    public boolean isUnique(String word) {
        String abbrev = toAbbrev(word);
        return !map.containsKey(abbrev) || map.get(abbrev).size() == 1 && map.get(abbrev).contains(word);
    }

    private String toAbbrev(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
    }
}
