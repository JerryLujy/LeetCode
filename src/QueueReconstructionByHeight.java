import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>406. Queue Reconstruction by Height</h1>
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number
 * of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.
 * <p>
 * Note: The number of people is less than 1100.
 * <p>
 * Example: Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]],  Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author Jerry
 * @since 1/15/19
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        List<int[]> l = new ArrayList<>();
        for (int[] p : people) {
            l.add(p[1], p);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = l.get(i);
        }
        return people;
    }
}
