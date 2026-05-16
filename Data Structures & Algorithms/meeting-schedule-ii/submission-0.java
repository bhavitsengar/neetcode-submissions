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
    public int minMeetingRooms(List<Interval> intervals) {

        PriorityQueue<Interval> pQueue = new PriorityQueue<>((a, b) -> a.start - b.start);
        intervals.stream().forEach((a) -> {
            pQueue.add(a);
        });

        PriorityQueue<Interval> rooms = new PriorityQueue<>((a, b) -> a.end - b.end);

        while(!pQueue.isEmpty()) {

            Interval interval = pQueue.poll();

            if(rooms.isEmpty()) {
                rooms.add(interval);
            } else {
                Interval room = rooms.peek();
                if(room.end <= interval.start) {
                    rooms.poll();

                    Interval newInterval = new Interval(room.start, interval.end);
                    rooms.add(newInterval);
                } else {
                    rooms.add(interval);
                }
            }
            
        }

        return rooms.size();

    }
}
