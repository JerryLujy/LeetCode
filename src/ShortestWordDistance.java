/**
 * <h1>243. Shortest Word Distance</h1>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * @author Jerry
 * @since 2/3/17
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE, a = -1, b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            }
            if (words[i].equals(word2)) {
                b = i;
            }
            if (a >= 0 && b >= 0) {
                ans = Math.min(ans, Math.abs(b - a));
            }
        }
        return ans;
    }
}
