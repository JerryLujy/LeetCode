import support.ListNode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <h1>817. Linked List Components</h1>
 * We are given head, the head node of a linked list containing unique integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * <p>
 * Example 1: Input: head: 0->1->2->3, G = [0, 1, 3]. Output: 2
 * Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * <p>
 * Example 2: Input: head: 0->1->2->3->4, G = [0, 3, 1, 4]. Output: 2
 * Explanation: 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * <p>
 * Note:
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 *
 * @author Jerry
 * @since 1/30/19
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = Arrays.stream(G).boxed().collect(Collectors.toSet());
        ListNode prev = null;
        while (head != null) {
            if (prev != null && set.contains(prev.val) && set.contains(head.val)) {
                set.remove(prev.val);
            }
            prev = head;
            head = head.next;
        }
        return set.size();
    }
}
