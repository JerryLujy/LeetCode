import support.ListNode;

/**
 * <h1>19. Remove Nth Node From End of List</h1>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example, given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Given n will always be valid.
 *
 * @author Jerry
 * @since 7/13/16
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head, b = head;
        while (n > 0) {
            f = f.next;
            n--;
        }
        if (f == null) {//remove the first node
            return head.next;
        }
        while (f.next != null) {
            f = f.next;
            b = b.next;
        }
        b.next = b.next.next;
        return head;
    }
}
