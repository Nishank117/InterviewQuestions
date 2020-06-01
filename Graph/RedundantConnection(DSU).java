class Solution{
    public int[] findRedundantConnection(int[][] edges){
        DisjointSet disjointSet = new DisjointSet(edges.length);
        for(int[] edge:edges){
            //if their parent's are same then we can remove them
            if(!disjointSet.union(edge[0]-1,edge[1]-1)) return edge;
        }
        return new int[2];
    }
}
class DisjointSet{
    private int[] parent;
    private byte[] rank;
    DisjointSet(int n){
        if(n<0) throw new IllegalArgumentException();
        parent = new int[n];
        rank = new byte[n];
    }

    private int find(int x){
        if(parent[x] == 0) return x;
        return parent[x] = find(parent[x]);
    }

    public boolean union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY) return false;

        if(rank[rootX]<rank[rootY]) parent[rootX] = rootY;
        else if(rank[rootX]>rank[rootY]) parent[rootY] = rootX;
        else{
            parent[rootX] = rootY;
            rank[rootY]++;
        }
        return true;
    }
    
}