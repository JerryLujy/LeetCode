import support.ListNode;

/**
 * <h1>141. Linked List Cycle</h1>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up: Can you solve it without using extra space?
 *
 * @author Jerry
 * @since 1/21/17
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head, runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}
