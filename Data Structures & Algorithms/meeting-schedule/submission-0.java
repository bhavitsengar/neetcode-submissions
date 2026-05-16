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

        PriorityQueue<Interval> pQueue = new PriorityQueue<>((a, b) -> a.start - b.start);
        intervals.stream().forEach((a) -> {
            pQueue.add(a);
        });

        int end = 0;
        while(!pQueue.isEmpty()) {

            Interval interval = pQueue.poll();

            if(interval.start < end) {
                return false;
            } else {
                end = interval.end;
            }
        }

        return true;

    }
}
