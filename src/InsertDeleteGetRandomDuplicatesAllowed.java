import java.util.*;

/**
 * <h1>381. Insert Delete GetRandom O(1) - Duplicates allowed</h1>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * <p>
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 *
 * @author Jerry
 * @since 2/12/17
 */
public class InsertDeleteGetRandomDuplicatesAllowed {
    private static Random rand = new Random();
    private List<Integer> list;
    private Map<Integer, Set<Integer>> positions;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomDuplicatesAllowed() {
        list = new ArrayList<>();
        positions = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean rtv;
        if (positions.containsKey(val)) {
            rtv = false;
        } else {
            positions.put(val, new LinkedHashSet<>());
            rtv = true;
        }
        positions.get(val).add(list.size());
        list.add(val);
        return rtv;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!positions.containsKey(val)) {
            return false;
        }
        int pos = positions.get(val).iterator().next();
        positions.get(val).remove(pos);

        if (pos != list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(pos, lastVal);
            positions.get(lastVal).remove(list.size() - 1);
            positions.get(lastVal).add(pos);
        }
        list.remove(list.size() - 1);
        if (positions.get(val).isEmpty()) {
            positions.remove(val);
        }
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
