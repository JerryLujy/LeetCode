import support.ListNode;

/**
 * <h1>24. Swap Nodes in Pairs</h1>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author Jerry
 * @since 8/13/16
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {// cur is never null
            ListNode tmp = cur.next.next.next;
            cur.next.next.next = cur.next;
            cur.next = cur.next.next;
            cur.next.next.next = tmp;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
