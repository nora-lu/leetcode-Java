/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.   */

public int minMeetingRooms(Interval[] intervals) {
  Integer[] times = new Integer[intervals.length * 2];
  int i = 0;
  for (Interval interval : intervals) {
    times[i++] = interval.start;
    times[i++] = -interval.end;
  }
  Arrays.sort(times, new Comparator<Integer>(){
    public int compare(Integer x, Integer y){
      int diff = Math.abs(x) - Math.abs(y);
      return diff == 0 ? x - y : diff;  // IMPORTANT: If start and end times are same, put end time first.
    }});
  int max = 0, cur = 0;
  for (int t : times) {
    if (t >= 0) { max = Math.max(max, ++cur); }
    else { cur--; }
  }
  return max;
}
