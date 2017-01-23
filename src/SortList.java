/**
 * <h1>148. Sort List</h1>
 * Sort a linked list in O(nlogn) time using constant space complexity.
 *
 * @author Jerry
 * @since 1/22/17
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Find mid point
        ListNode walker = head, runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        // Sort recursively
        ListNode tail = sortList(walker.next);
        walker.next = null;
        head = sortList(head);
        // Merge
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head != null && tail != null) {
            if (head.val <= tail.val) {
                cur.next = head;
                head = head.next;
            } else {
                cur.next = tail;
                tail = tail.next;
            }
            cur = cur.next;
        }
        if (head != null) {
            cur.next = head;
        }
        if (tail != null) {
            cur.next = tail;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
