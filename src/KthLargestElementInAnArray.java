import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>215. Kth Largest Element in an Array</h1>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note: You may assume k is always valid, 1 <= k <= array's length.
 *
 * @author Jerry
 * @since 1/29/17
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
