class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] time : times) {
            List<int[]> neighbours = graph.getOrDefault(time[0], new ArrayList<>());
            neighbours.add(new int[]{time[1], time[2]});
            graph.put(time[0], neighbours);
        }

        int[] dis = new int[n+1];

        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[0] = 0;
        dis[k] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        heap.add(new int[]{k, 0});

        int[] visited = new int[n+1];

        while(!heap.isEmpty()) {

            int[] node = heap.poll();

            if(dis[node[0]] > node[1]) {
                dis[node[0]] = node[1];
            }

            if(visited[node[0]] == 1) {
                continue;
            }

            visited[node[0]] = 1;

            List<int[]> neighbours = graph.getOrDefault(node[0], new ArrayList<>());

            for(int[] neighbour : neighbours) {

                heap.add(new int[]{neighbour[0], node[1] + neighbour[1]});
            }
        }

        int max = 0;

        for(int shortest : dis) {
            max = Math.max(shortest, max);
        }
        
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
