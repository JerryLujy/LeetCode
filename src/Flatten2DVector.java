import java.util.Iterator;
import java.util.List;

/**
 * <h1>251. Flatten 2D Vector</h1>
 * Implement an iterator to flatten a 2d vector.
 * <p>
 * For example,Given 2d vector = [[1,2],[3],[4,5,6]]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 *
 * @author Jerry
 * @since 2/4/17
 */
public class Flatten2DVector implements Iterator<Integer> {
    private int i, j;
    private List<List<Integer>> vec;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        i = -1;
        j = 0;
        vec = vec2d;
        while (++i < vec2d.size() && vec2d.get(i).isEmpty()) ;
    }

    @Override
    public Integer next() {
        Integer val = vec.get(i).get(j++);
        if (j >= vec.get(i).size()) {
            j = 0;
            while (++i < vec.size() && vec.get(i).isEmpty()) ;
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        return i < vec.size() && j < vec.get(i).size();
    }
}
