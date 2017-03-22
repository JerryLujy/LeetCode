import support.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>57. Insert Interval</h1>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * @author Jerry
 * @since 8/28/16
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        List<Interval> rst = new ArrayList<>();
        int pos = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.end < newInterval.start) {
                rst.add(cur);
                pos = i + 1;
            } else if (cur.start > newInterval.end) {
                rst.add(cur);
            } else {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }
        rst.add(pos, newInterval);
        return rst;
    }
}
