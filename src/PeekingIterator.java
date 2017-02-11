import java.util.Iterator;

/**
 * <h1>284. Peeking Iterator</h1>
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 *
 * @author Jerry
 * @since 2/10/17
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer cache;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        cache = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache == null) {
            cache = iter.next();
        }
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cache != null) {
            Integer value = cache;
            cache = null;
            return value;
        }
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext() || cache != null;
    }
}
