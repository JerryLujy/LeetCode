import support.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h1>252. Meeting Rooms</h1>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 *
 * @author Jerry
 * @since 2/4/17
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}
