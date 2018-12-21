import support.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>143. Reorder List</h1>
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln,
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2→...
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * @author Jerry
 * @since 1/21/17
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            stack.push(head);
            head = head.next;
            runner = runner.next.next;
        }
        // Head is now at mid node(odd nodes) / latter of the two mid node(even nodes)
        ListNode next = head.next;
        head.next = null;
        if (runner == null) {// Even number of nodes
            head = stack.pop();// Go back one node
        }
        while (!stack.isEmpty()) {
            stack.peek().next = next;
            next = next.next;
            stack.peek().next.next = head;
            head = stack.pop();
        }
    }
}
