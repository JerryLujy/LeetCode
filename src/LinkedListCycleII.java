/**
 * <h1>142. Linked List Cycle II</h1>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * <p>
 * Follow up: Can you solve it without using extra space?
 *
 * @author Jerry
 * @since 1/21/17
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode walker = head, runner = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                runner = head;
                while (runner != walker) {
                    runner = runner.next;
                    walker = walker.next;
                }
                return walker;
            }
        }
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
