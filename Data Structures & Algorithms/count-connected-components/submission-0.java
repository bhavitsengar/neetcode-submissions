class Solution {
    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges) {
            
            uf.union(edge[0], edge[1]);
        }

        return uf.components;
    }
}

class UnionFind {

    int components;
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        this.components = n;
        this.parent = new int[n];
        this.rank = new int[n];

        Arrays.fill(rank, 1);

        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {

        if(parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    public void union(int x, int y) {

        int pX = find(x);
        int pY = find(y);

        if(pX == pY) {
            return;
        }

        if(rank[pX] > rank[pY]) {
            parent[pY] = pX;
        } else {
            parent[pX] = pY;
        }

        components--;
    }

}
