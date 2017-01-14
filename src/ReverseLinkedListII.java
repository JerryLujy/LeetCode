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
        ListNode curr = head, prev = null;
        for (int i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode tmp = prev; // Save the position where the reversal starts
        ListNode succ = curr.next;
        for (int i = m; i < n; i++) {
            curr.next = prev;
            prev = curr;
            curr = succ;
            succ = curr.next;
        }
        curr.next = prev;
        if (tmp == null) {
            head.next = succ;
            return curr;
        } else {
            tmp.next.next = succ;
            tmp.next = curr;
            return head;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
