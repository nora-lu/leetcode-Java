/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) { return 0; }
        // sort intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start > i2.start ? 1 : i1.start < i2.start ? -1 : 0;
            }
            
        });
        List<Interval> meetings = new ArrayList<>();
        meetings.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval meetingNow = intervals[i];
            for (int j = 0; j < meetings.size(); j++) {
                if (meetingNow.start >= meetings.get(j).end) {
                    meetings.remove(j);
                    break;
                }
            }
            meetings.add(meetingNow);
        }
        return meetings.size();
    }
}
