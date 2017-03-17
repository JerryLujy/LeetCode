import support.ListNode;

/**
 * <h1>92. Reverse Linked List II</h1>
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition: 1 <= m <= n <= length of list.
 *
 * @author Jerry
 * @since 1/13/17
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0), tail = dummy;
        dummy.next = head;
        for (int i = 1; i < m; i++) {
            tail = tail.next;
        }
        head = tail.next;
        for (int i = m; i < n; i++) {
            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = tail.next;
            tail.next = curr;
        }
        return dummy.next;
    }
}
