class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0)
            return false;


        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        Arrays.stream(hand).forEach((a) -> {
            pQueue.add(a);
        });

        int size = 0;
        int groups = 0;
        int prev = -1;
        List<Integer> temp = new LinkedList<>();
        while(!pQueue.isEmpty()) {
            
            int card = pQueue.poll();

            System.out.println(card);

            if(prev == -1 || card != prev) {
                if(prev != -1 && card > prev + 1) {
                    return false;
                }
                size++;
                prev = card;
            } else {
                temp.add(card);
            }

            if(size == groupSize) {
                groups++;
                size = 0;
                prev = -1;
                pQueue.addAll(temp);
                temp.clear();
            }
        }

        if(groups == (hand.length/groupSize))
            return true;
        
        return false;
    }
}