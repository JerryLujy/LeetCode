import support.ListNode;

/**
 * <h1>61. Rotate List</h1>
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 *
 * @author Jerry
 * @since 8/29/16
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), l = dummy, r = dummy;
        dummy.next = head;

        int len = 0;
        for (; r.next != null; r = r.next) {
            len++;
        }
        for (int i = 0; i < len - k % len; i++) {
            l = l.next;
        }
        r.next = dummy.next;
        dummy.next = l.next;
        l.next = null;
        return dummy.next;
    }
}
