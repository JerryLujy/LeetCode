import java.util.HashMap;
import java.util.Map;

/**
 * <h1>146. LRU Cache</h1>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * <p>
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up: Could you do both operations in O(1) time complexity?
 *
 * @author Jerry
 * @since 1/22/17
 */
public class LRUCache {
    private DoubleLinkNode head, tail;
    private Map<Integer, DoubleLinkNode> cache;
    private int maxSize;

    public LRUCache(int capacity) {
        head = new DoubleLinkNode(0, 0);
        tail = new DoubleLinkNode(0, 0);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>(capacity);
        maxSize = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DoubleLinkNode node = cache.get(key);
        detach(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkNode node = cache.get(key);
            detach(node);
            node.val = value;
            add(node);
        } else {
            if (cache.size() == maxSize) {
                cache.remove(head.next.key);
                detach(head.next);
            }
            DoubleLinkNode newNode = new DoubleLinkNode(key, value);
            cache.put(key, newNode);
            add(newNode);
        }
    }

    private void detach(DoubleLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node.next = null;
    }

    private void add(DoubleLinkNode node) {
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        node.next.prev = node;
    }

    private static class DoubleLinkNode {
        int key, val;
        DoubleLinkNode prev, next;

        DoubleLinkNode(int k, int v) {
            key = k;
            val = v;
        }
    }
}
