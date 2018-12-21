import support.ListNode;

/**
 * <h1>147. Insertion Sort List</h1>
 * Sort a linked list using insertion sort.
 *
 * @author Jerry
 * @since 1/22/17
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode curr = head;
            head = head.next;

            ListNode prev = dummy;
            while (prev.next != null && curr.val > prev.next.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
        }
        return dummy.next;
    }
}
