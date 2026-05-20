class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                
                if(grid[i][j] == 1) {
                    int[][] visited = new int[grid.length][grid[0].length];
                    int area = parse(grid, i, j, visited);
                    max = Math.max(max, area);
                }
            }
        }

        return max;

    }

    private int parse(int[][] grid, int i, int j, int[][] visited) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if(visited[i][j] == 1)
            return 0;

        visited[i][j] = 1;

        if(grid[i][j] == 0 || grid[i][j] == 2)
            return 0;
        
        grid[i][j] = 2;

        return 1 + parse(grid, i-1, j, visited) + parse(grid, i+1, j, visited) +  parse(grid, i, j-1, visited) + parse(grid, i, j+1, visited);

    }
}
