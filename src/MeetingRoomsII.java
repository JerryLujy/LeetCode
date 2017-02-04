import java.util.ArrayList;
import java.util.List;

/**
 * <h1>253. Meeting Rooms II</h1>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 *
 * @author Jerry
 * @since 2/4/17
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        List<int[]> timeStamps = new ArrayList<>();
        for (Interval i : intervals) {
            timeStamps.add(new int[]{i.start, 1});
            timeStamps.add(new int[]{i.end, -1});
        }
        timeStamps.sort((int[] a, int[] b) -> {
            int compareTime = Integer.compare(a[0], b[0]);
            if (compareTime == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return compareTime;
        });
        int ans = 0, cur = 0;
        for (int[] t : timeStamps) {
            if (t[1] < 0) {
                cur--;
            } else {
                cur++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public class Interval {
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
