import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>179. Largest Number</h1>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * @author Jerry
 * @since 1/26/17
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            long aa = a * 10, bb = b * 10;
            for (int i = a / 10; i > 0; i /= 10) {
                bb *= 10;
            }
            for (int i = b / 10; i > 0; i /= 10) {
                aa *= 10;
            }
            return -Long.compare(aa + b, bb + a);
        });
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            queue.offer(num);
        }
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
