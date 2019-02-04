import java.util.HashMap;
import java.util.Map;

/**
 * <h1>914. X of a Kind in a Deck of Cards</h1>
 * In a deck of cards, each card has an integer written on it.
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * Each group has exactly X cards. All the cards in each group have the same integer.
 * <p>
 * Example 1: Input: [1,2,3,4,4,3,2,1], Output: true. Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * <p>
 * Example 2: Input: [1,1,1,2,2,2,3,3], Output: false. Explanation: No possible partition.
 * <p>
 * Example 3: Input: [1], Output: false. Explanation: No possible partition.
 * <p>
 * Example 4: Input: [1,1], Output: true. Explanation: Possible partition [1,1]
 * <p>
 * Example 5: Input: [1,1,2,2,2,2], Output: true. Explanation: Possible partition [1,1],[2,2],[2,2]
 * <p>
 * Note:
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * @author Jerry
 * @since 2/3/19
 */
public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.merge(i, 1, Integer::sum);
        }
        int d = -1;
        for (int i : map.values()) {
            if (d == -1) {
                d = i;
            } else {
                d = gcd(d, i);
            }
        }
        return d >= 2;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
