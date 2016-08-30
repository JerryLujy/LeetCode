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
        if (head == null) {
            return null;
        }
        ListNode dummy = head;
        int length = 0;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }
        k = k % length;

        dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode tail = dummy;
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = dummy.next;
        dummy.next = head.next;
        head.next = null;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
