class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : prerequisites) {
            indegree[edge[0]]++;

            List<Integer> neighbours = graph.getOrDefault(edge[1], new ArrayList<>());

            neighbours.add(edge[0]);

            graph.put(edge[1], neighbours);

        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int topoCount = 0;

        int[] visited = new int[numCourses];

        while(!queue.isEmpty()) {

            int course = queue.poll();
            topoCount++;

            List<Integer> neighbours = graph.getOrDefault(course, new ArrayList<>());

            for(int nextCourse : neighbours) {

                if(--indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }

        }

        if(topoCount == numCourses)
            return true;

        return false;

    }
}
