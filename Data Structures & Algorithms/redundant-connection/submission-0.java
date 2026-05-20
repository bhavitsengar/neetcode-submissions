class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        DisjointSet ds = new DisjointSet(edges.length);

        for(int[] edge : edges) {

            boolean join = ds.union(edge[0], edge[1]);

            if(!join)
                return edge;
        }

        return new int[]{};

    }
}


class DisjointSet {

    int[] parent;
    int[] rank;
    int components;

    public DisjointSet(int n) {
        this.components = n;
        this.rank = new int[n+1];
        this.parent = new int[n+1];

        for(int i = 1; i<=n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int x) {

        if(parent[x] == x) {
            return x;
        }

        parent[x] = findParent(parent[x]);

        return parent[x];
    }

    public boolean union(int x, int y) {

        int pX = findParent(x);
        int pY = findParent(y);

        if(pX == pY) {
            return false;
        }

        if(rank[pX] > rank[pY]) {
            parent[pY] = pX;
            rank[pX]++;
        } else {
            parent[pX] = pY;
            rank[pY]++;
        }

        components++;

        return true;
    }
}
