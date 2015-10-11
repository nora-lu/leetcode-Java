/* Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. */

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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) { return null; }
        List<Interval> merge = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }
        });
        
        for (Interval i : intervals) {
            if (merge.isEmpty()) { merge.add(i); }
            else {
                Interval prev = merge.get(merge.size() - 1);
                if (i.start <= prev.end) {
                    prev.end = Math.max(i.end, prev.end);  // merge
                } else {
                    merge.add(i);
                }
            }
        }
        return merge;
    }
}
