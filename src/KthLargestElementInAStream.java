import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>703. Kth Largest Element in a Stream</h1>
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * Note:
 * You may assume that nums' length >= k-1 and k >= 1.
 *
 * @author Jerry
 * @since 1/29/19
 */
public class KthLargestElementInAStream {
    int size;
    Queue<Integer> q;

    public KthLargestElementInAStream(int k, int[] nums) {
        q = new PriorityQueue<>();
        size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        q.offer(val);
        if (q.size() > size) {
            q.poll();
        }
        return q.peek();
    }
}
