/**
 * Use a Priority Queue. O(NlogN) time.
 */
public class MeetingRoomsII {
  public int minRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) { return 0; }
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b){
          return a.start - b.start;}});
    PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length,
        new Comparator<Interval>(){
          public int compare(Interval a, Interval b){
            return a.end - b.end; }});
    pq.offer(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      Interval endEarliest = pq.poll();
      if (endEarliest.end <= intervals[i].start) {
        endEarliest.end = intervals[i].end;  // using the same room, but with new end time
      } else {
        pq.offer(intervals[i]);
      }
      pq.offer(endEarliest);
    }
    return pq.size();
  }
}
