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
        ListNode cur = dummy;

        ListNode tmp1, tmp2;
        while (cur != null && (tmp1 = kth(cur, k)) != null) {
            tmp2 = tmp1.next;
            for (int i = k - 1; i >= 1; i--) {
                ListNode from = kth(cur, i);
                from.next.next = from;
            }
            cur.next.next = tmp2;
            cur.next = tmp1;
            cur = kth(cur, k);
        }
        return dummy.next;
    }

    // Get the k-th node from node s
    private ListNode kth(ListNode s, int k) {
        for (int i = 0; i < k; i++) {
            if (s.next == null) {
                return null;
            } else {
                s = s.next;
            }
        }
        return s;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
