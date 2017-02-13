import java.util.*;

/**
 * <h1>373. Find K Pairs with Smallest Sums</h1>
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1: Given nums1 = [1,7,11], nums2 = [2,4,6], k = 3. Return: [1,2],[1,4],[1,6].
 * The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * Example 2: Given nums1 = [1,1,2], nums2 = [1,2,3], k = 2. Return: [1,1],[1,1].
 * The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * Example 3: Given nums1 = [1,2], nums2 = [3], k = 3. Return: [1,3],[2,3]
 * All possible pairs are returned from the sequence: [1,3],[2,3]
 *
 * @author Jerry
 * @since 2/12/17
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return ans;
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p[0] + p[1]));
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            ans.add(new int[]{curr[0], curr[1]});
            if (curr[2] < nums2.length - 1) {
                queue.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
            }
        }
        return ans;
    }
}
