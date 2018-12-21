import support.ListNode;

/**
 * <h1>237. Delete Node in a Linked List</h1>
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 * @author Jerry
 * @since 2/2/17
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
