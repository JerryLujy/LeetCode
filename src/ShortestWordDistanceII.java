import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>244. Shortest Word Distance II</h1>
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your
 * method will be called repeatedly many times with different parameters. How would you optimize it?
 * <p>
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1
 * and word2 and return the shortest distance between these two words in the list.
 * <p>
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * @author Jerry
 * @since 2/3/17
 */
public class ShortestWordDistanceII {
    private Map<String, List<Integer>> posMap;

    public ShortestWordDistanceII(String[] words) {
        posMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!posMap.containsKey(word)) {
                posMap.put(word, new ArrayList<>());
            }
            posMap.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        for (int pos1 : posMap.get(word1)) {
            for (int pos2 : posMap.get(word2)) {
                ans = Math.min(ans, Math.abs(pos1 - pos2));
            }
        }
        return ans;
    }
}
