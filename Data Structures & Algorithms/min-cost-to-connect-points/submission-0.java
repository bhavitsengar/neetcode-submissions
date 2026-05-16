class Solution {
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1]-b[1]);
            
        heap.add(new int[]{0, 0, -1});

        int[] visited = new int[points.length];

        int sum = 0;
        
        while(!heap.isEmpty()) {

            int[] node = heap.poll();

            int curr = node[0];
            int dis = node[1];
            int parent = node[2];

            if(visited[curr] == 1) {
                continue;
            }

            visited[curr] = 1;

            if(parent != -1) {
                sum += dis;
            }

            for(int i = 0; i<points.length; i++) {
                if(visited[i] != 1) {
                    int[] p1 = points[curr];
                    int[] p2 = points[i];

                    int md = getMD(p1, p2);

                    heap.add(new int[]{i, md, curr});
                }
            }
        }

        return sum;
    }

    private int getMD(int[] p1, int[] p2) {

        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
