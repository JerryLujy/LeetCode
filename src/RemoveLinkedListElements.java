import support.ListNode;

/**
 * <h1>203. Remove Linked List Elements</h1>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example: Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6, Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 * @author Jerry
 * @since 1/27/17
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
