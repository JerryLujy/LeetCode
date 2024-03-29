import support.UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>737. Sentence Similarity II</h1>
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar,
 * if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 *
 * Note:
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 *
 * @author Jerry
 * @since 1/27/19
 */
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        UnionFind uf = new UnionFind(4000);
        Map<String, Integer> toId = new HashMap<>();
        int id = 0;
        for (String[] pair : pairs) {
            for (String s : pair) {
                if (!toId.containsKey(s)) {
                    toId.put(s, id++);
                }
            }
            uf.union(toId.get(pair[0]), toId.get(pair[1]));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && (!toId.containsKey(words1[i]) || !toId.containsKey(words2[i]) || uf.find(toId.get(words1[i])) != uf.find(toId.get(words2[i])))) {
                return false;
            }
        }
        return true;
    }
}
