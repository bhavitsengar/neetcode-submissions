class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length < n-1 || edges.length > n-1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges) {

            uf.union(edge[0], edge[1]);

        }

        
        return uf.components == 1 ? true : false;
    }
}

class UnionFind {

    int components;
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        this.components = n;
        this.rank = new int[n];
        this.parent = new int[n];

        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
    }

    public boolean union(int x, int y) {

        int pX = find(x);
        int pY = find(y);

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

        this.components--;

        return false;
    }

    public int find(int x) {

        if(parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

}
