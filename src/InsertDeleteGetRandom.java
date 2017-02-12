import java.util.*;

/**
 * <h1>380. Insert Delete GetRandom O(1)</h1>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * @author Jerry
 * @since 2/12/17
 */
public class InsertDeleteGetRandom {
    private static Random rand = new Random();
    private List<Integer> list;
    private Map<Integer, Integer> positions;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        positions = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (positions.containsKey(val)) {
            return false;
        }
        positions.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!positions.containsKey(val)) {
            return false;
        }
        int pos = positions.get(val);
        positions.remove(val);

        if (pos != list.size() - 1) { // Swap with the last element
            int lastVal = list.get(list.size() - 1);
            positions.put(lastVal, pos);
            list.set(pos, lastVal);
        }
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
