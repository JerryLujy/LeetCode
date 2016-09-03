/**
 * <h1>86. Partition List</h1>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 *
 * @author Jerry
 * @since 9/3/16
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode ldummy = new ListNode(0);
        ListNode rdummy = new ListNode(0);
        ListNode l = ldummy;
        ListNode r = rdummy;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        r.next = null;// Avoid loop
        l.next = rdummy.next;
        return ldummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
