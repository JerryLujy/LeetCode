import java.util.*;

/**
 * <h1>347. Top K Frequent Elements</h1>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 <= k <= number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author Jerry
 * @since 2/26/17
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.merge(num, 1, Integer::sum);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> ans = new LinkedList<>();
        while (!pq.isEmpty()) {
            ans.add(0, pq.poll().getKey());
        }
        return ans;
    }
}
