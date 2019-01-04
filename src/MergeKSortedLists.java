import support.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h1>23. Merge k Sorted Lists</h1>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * @author Jerry
 * @since 8/6/16
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode list = pq.poll();
            cur.next = list;
            cur = cur.next;
            list = list.next;
            if (list != null) {
                pq.offer(list);
            }
        }
        return dummy.next;
    }
}
