import java.util.Random;

/**
 * <h1>382. Linked List Random Node</h1>
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 * <p>
 * Follow up: What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 * @author Jerry
 * @since 3/6/17
 */
public class LinkedListRandomNode {
    private ListNode head;
    private Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        // Reservoir sampling
        int ans = head.val;
        ListNode cur = head.next;
        for (int i = 1; cur != null; cur = cur.next, i++) {
            if (random.nextInt(i + 1) == 0) {
                ans = cur.val;
            }
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
