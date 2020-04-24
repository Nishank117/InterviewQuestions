public class ArticulationPoint{
    int time;
    //DFS Util function to find the articulation points
    public void ArticulationPointDFSUtil(int[] disc,int[] low,boolean[] visited,int[] parent,boolean[] articulationPoint;int u){
        //number of children is important as we need to check the first condition
        int children = 0;
        visited[u] = true;
        disc[u]=low[u]=++time;

        Iterator<Integer> iterator = adj[u].iterator();
        while(iterator.hasNext()){
            int v = iterator.next(); // v is current adjacent of u

            // If v is not visited yet, then make it a child of u 
            // in DFS tree and recur for it 
            if(!visited[v]){
                chidren++;
                parent[v] = u;
                ArticulationPointDFSUtil(disc,low,visited,parent,articulationPoint,u);

                // Check if the subtree rooted with v has a connection to one of the ancestors of u
                low[v] = Math.min(low[u],low[v]);

                // u is an articulation point in following cases 
  
                // (1) u is root of DFS tree and has two or more chilren. 
                if(parent[u] == NIL && children>=2){
                    articulationPoint[u] = true;
                }

                // (2) If u is not root and low value of one of its child is more than discovery value of u
                if(parent[u] != NIL && low[v]>=disc[u]){
                    articulationPoint[u] = true;
                }

            }
            
            // Update low value of u for parent function calls.
            else if(v != parent[u]){
                low[u] = Math.min(low[u],disc[v]);
            }
        }

    }
    //DFS function to find articulation point
    public void ArticulationPointDFS(int vertices){
        int[] discoveryTime = new int[vertices];
        int[] lowTime = new int[vertices];
        boolean[] visited = new int[vertices];
        int[] parent = new int[vertices];
        boolean[] articulationPoint = new boolean[vertices];

        //Initialization
        for(int i = 0;i <= vertices;i++){
            parent[i] = NIL;
            visited[i] = false;
            articulationPoint[i] = false;
        }
        for(int i = 0;i <= vertices;i++){
            if(visited[i] == false){
                ArticulationPointFindUtil(discoveryTime,lowTime,visited,parent,articulationPoint,i);
            }
        }

        for(int i = 0;i <= vertices;i++){
            if(articulationPoint[i]){
                System.out.println(i);
            }
        }
    }
}