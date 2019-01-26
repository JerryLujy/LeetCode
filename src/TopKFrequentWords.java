import java.util.*;

/**
 * <h1>692. Top K Frequent Words</h1>
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2. Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * <p>
 * Example 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4. Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 *
 * @author Jerry
 * @since 1/25/19
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.merge(word, 1, Integer::sum);
        }
        Queue<String> q = new PriorityQueue<>((s1, s2) -> {
            if (count.get(s1).equals(count.get(s2))) {
                return s2.compareTo(s1);
            }
            return count.get(s1) - count.get(s2);
        });
        for (String s : count.keySet()) {
            q.offer(s);
            if (q.size() > k) {
                q.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
