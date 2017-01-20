import java.util.HashMap;
import java.util.Map;

/**
 * <h1>128. Longest Consecutive Sequence</h1>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example, Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 *
 * @author Jerry
 * @since 1/19/17
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int leftSize = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int rightSize = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int size = 1 + leftSize + rightSize;
            longest = Math.max(longest, size);
            map.put(num, size);
            map.put(num - leftSize, size);
            map.put(num + rightSize, size);
        }
        return longest;
    }
}
