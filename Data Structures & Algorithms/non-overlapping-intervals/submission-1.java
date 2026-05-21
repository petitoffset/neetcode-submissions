class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int curEnd = intervals[0][1];
        int deleted = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < curEnd) {
                deleted++;
                curEnd = Math.min(curEnd, intervals[i][1]);
            } else {
                curEnd = intervals[i][1];
            }
        }
        return deleted;
    }
}
