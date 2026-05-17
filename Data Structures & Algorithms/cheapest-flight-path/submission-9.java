
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] flight : flights) {

            List<int[]> neighbours = graph.getOrDefault(flight[0], new ArrayList<>());

            neighbours.add(new int[]{flight[1], flight[2]});

            graph.put(flight[0], neighbours);
        }

        int[] dis = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[src] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {

            return a[1]-b[1];
            
        });

        heap.add(new int[]{src, 0, 0});

        int[][] visited = new int[n][k+2];

        while(!heap.isEmpty()) {

            int[] node = heap.poll();

            int airport = node[0];
            int price = node[1];
            int hops = node[2];

            if(dis[airport] > price) {
                dis[airport] = price;
            }

            if(visited[airport][hops] == 1) {
                continue;
            }

            visited[airport][hops] = 1;

            List<int[]> neighbours = graph.getOrDefault(airport, new ArrayList<>());

            //System.out.println(airport);
            //System.out.println("hops :"+hops);
                
            if(hops < k+1) {
                for(int[] neighbour : neighbours) {

                    //System.out.println(Arrays.toString(neighbour));
                    heap.add(new int[]{neighbour[0], price+neighbour[1], hops+1});
                    
                }
            }
        }

        if(dis[dst] != Integer.MAX_VALUE) {
            return dis[dst];
        } else {
            return -1;
        }
    }
}
