import support.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * <h1>352. Data Stream as Disjoint Intervals</h1>
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p>
 * [1, 1];
 * [1, 1], [3, 3];
 * [1, 1], [3, 3], [7, 7];
 * [1, 3], [7, 7];
 * [1, 3], [6, 7];
 * <p>
 * Follow up: What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 *
 * @author Jerry
 * @since 2/27/17
 */
public class DataStreamAsDisjointIntervals {
    private TreeSet<Interval> ranges;

    /**
     * Initialize your data structure here.
     */
    public DataStreamAsDisjointIntervals() {
        ranges = new TreeSet<>(Comparator.comparingInt(e -> e.start));
    }

    public void addNum(int val) {
        Interval i = new Interval(val, val);
        Interval prev = ranges.floor(i), next = ranges.ceiling(i);
        if (prev != null && prev.end + 1 == val) {
            ranges.remove(prev);
            i.start = prev.start;
        }
        if (next != null && next.start - 1 == val) {
            ranges.remove(next);
            i.end = next.end;
        }
        if ((prev == null || val > prev.end) && (next == null || val < next.start)) {
            ranges.add(i);
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(ranges);
    }
}
