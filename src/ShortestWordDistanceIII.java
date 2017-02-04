/**
 * <h1>245. Shortest Word Distance III</h1>
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes", word2 = "makes", return 3.
 * <p>
 * Note: You may assume word1 and word2 are both in the list.
 *
 * @author Jerry
 * @since 2/3/17
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE, a = -1, b = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word1.equals(word) && word2.equals(word)) {
                if (a < b) {
                    a = i;
                } else {
                    b = i;
                }
            } else if (word1.equals(word)) {
                a = i;
            } else if (word2.equals(word)) {
                b = i;
            }
            if (a >= 0 && b >= 0) {
                ans = Math.min(ans, Math.abs(a - b));
            }
        }
        return ans;
    }
}
