import java.util.HashSet;
import java.util.Set;

/**
 * <h1>771. Jewels and Stones</h1>
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1: Input: J = "aA", S = "aAAbbbb", Output: 3
 * <p>
 * Example 2: Input: J = "z", S = "ZZ", Output: 0
 * <p>
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 * @author Jerry
 * @since 1/28/19
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> j = new HashSet<>();
        for (char c : J.toCharArray()) {
            j.add(c);
        }
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (j.contains(c)) {
                ans++;
            }
        }
        return ans;
    }
}
