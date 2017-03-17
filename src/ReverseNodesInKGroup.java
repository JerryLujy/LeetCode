import support.ListNode;

/**
 * <h1>25. Reverse Nodes in k-Group</h1>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * <p>
 * For example, Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 *
 * @author Jerry
 * @since 8/19/16
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        while (hasEnough(tail, k)) {
            head = tail.next;
            for (int i = 0; i < k - 1; i++) { // Flip k - 1 links between k nodes
                ListNode curr = head.next;
                head.next = curr.next;
                curr.next = tail.next;
                tail.next = curr;
            }
            tail = head;
        }
        return dummy.next;
    }

    private boolean hasEnough(ListNode tail, int k) {
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return false;
            }
            tail = tail.next;
        }
        return tail != null;
    }
}
