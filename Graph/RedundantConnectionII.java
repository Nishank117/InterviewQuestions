class Solution{
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len+1];
        int edgesRemoved = -1;
        int edgeMakeCycle = -1;
        for(int i = 0;i<len;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            if(parent[dest]!= 0){
                edgesRemoved = i;
                break;
            }else{
                parent[dest] = src;
            }
        }
        UnionFind uf = new UnionFind(len);
        for(int i = 0;i<edges.length;i++){
            if( i == edgesRemoved) continue;
            if(!uf.union(edges[i][0],edges[i][1])){
                edgeMakeCycle = i;
                break;
            }
        }
        //if no edges were removed
        //the answer is directly the edge that makes cycle.
        if(edgesRemoved == -1){
            return edges[edgeMakeCycle];
        }
        
        if(edgeMakeCycle != -1){
            int dest = edges[edgesRemoved][1];
            int src = parent[dest];
            return new int[]{src,dest};
        }

        return edges[edgesRemoved];
    }
}
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return false;
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        } else {
            parent[rootY] = rootX;
            rank[rootX] += rank[rootY];
        }
        return true;
    }
}