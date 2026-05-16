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

        PriorityQueue<Integer> startTimes = new PriorityQueue<>();

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        intervals.stream().forEach((a) -> {
            startTimes.add(a.start);
            endTimes.add(a.end);
        });

        int count = 0;

        int rooms = 0;

        while(!startTimes.isEmpty() || !endTimes.isEmpty()) {
            
            Integer start = startTimes.peek();
            Integer end = endTimes.peek();

            if(start != null && end != null) {
                
                if(start < end) {
                    startTimes.poll();
                    count++;
                    rooms = Math.max(rooms, count);
                } else  {
                    endTimes.poll();
                    count--;
                }

            } else {
                endTimes.poll();
                count--;
            }

        }

        return rooms;
        
    }
}
