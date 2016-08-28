import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>56. Merge Intervals</h1>
 * Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 *
 * @author Jerry
 * @since 8/28/16
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> merged = new ArrayList<>();
        Interval last = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= last.end) {
                last.end = Math.max(last.end, cur.end);
            } else {
                merged.add(last);
                last = new Interval(cur.start, cur.end);
            }
        }
        merged.add(last);
        return merged;
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
