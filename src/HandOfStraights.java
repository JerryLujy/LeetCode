import java.util.TreeMap;

/**
 * <h1>846. Hand of Straights</h1>
 * Alice has a hand of cards, given as an array of integers.
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * Return true if and only if she can.
 * <p>
 * Example 1: Input: hand = [1,2,3,6,2,3,4,7,8], W = 3. Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * <p>
 * Example 2: Input: hand = [1,2,3,4,5], W = 4. Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * <p>
 * Note:
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 *
 * @author Jerry
 * @since 2/1/19
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int i : hand) {
            counts.merge(i, 1, Integer::sum);
        }
        for (int i = 0; i < hand.length / W; i++) {
            int expected = counts.firstKey();
            for (int j = 0; j < W; j++) {
                if (!counts.containsKey(expected)) {
                    return false;
                }
                if (counts.get(expected) > 1) {
                    counts.merge(expected, -1, Integer::sum);
                } else {
                    counts.remove(expected);
                }
                expected++;
            }
        }
        return true;
    }
}
