import support.Interval;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) {
            return ans;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= end) {
                end = Math.max(end, cur.end);
            } else {
                ans.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}
