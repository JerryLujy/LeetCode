import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>295. Find Median from Data Stream</h1>
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * Examples: [2,3,4] , the median is 3. [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * For example:
 * addNum(1),
 * addNum(2),
 * findMedian() -> 1.5,
 * addNum(3),
 * findMedian() -> 2
 *
 * @author Jerry
 * @since 2/11/17
 */
public class FindMedianFromDataStream {
    private Queue<Integer> maxHeap, minHeap;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }
}
