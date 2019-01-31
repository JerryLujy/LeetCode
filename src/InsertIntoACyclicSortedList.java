import support.ListNode;

/**
 * <h1>708. Insert into a Cyclic Sorted List</h1>
 * Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into
 * the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.
 * If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.
 *
 * @author Jerry
 * @since 1/30/19
 */
public class InsertIntoACyclicSortedList {
    public ListNode insert(ListNode head, int insertVal) {
        ListNode newNode = new ListNode(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode cur = head;
        while (cur.next != head) {
            if (cur.val <= insertVal && insertVal <= cur.next.val
                    || cur.val > cur.next.val && cur.val < insertVal
                    || cur.val > cur.next.val && insertVal < cur.next.val) {
                break;
            }
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }
}
