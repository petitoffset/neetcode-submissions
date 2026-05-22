/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0 || intervals.size() == 1) return true;
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        int curEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < curEnd) {
                return false;
            } else {
                curEnd = intervals.get(i).end;
            }
        }
        return true;
    }
}
