public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) { return 0; }
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        int i = 0;
        for (Interval it : intervals) {
            startTimes[i] = it.start;
            endTimes[i] = it.end;
            i++;
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        // similar to merge step
        int count = 0, s = 0, e = 0, max = 0;
        while (s < startTimes.length && e < endTimes.length) {
            if (startTimes[s] < endTimes[e]) {
                max = Math.max(max, ++count);
                s++;
            } else {
                count--;
                e++;
            }
        }
        return max;
    }
}
