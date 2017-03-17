import support.ListNode;

/**
 * <h1>206. Reverse Linked List</h1>
 * Reverse a singly linked list.
 *
 * @author Jerry
 * @since 1/27/17
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
