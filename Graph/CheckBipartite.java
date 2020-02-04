class GfG
{
      boolean bipartite = true;
      private void dfs(boolean[] visited,int[] color,int[][] grid,int src,int curr){
          visited[src] = true;
          color[src] = curr;
          for(int i = 0;i<visited.length;i++){
              if(grid[src][i] == 1){
                  if(color[i] == curr){
                      bipartite = false;
                      return;
                  }
              }
              if(!visited[i]){
                  dfs(visited,color,grid,i,curr==1?2:1);
              }
          }
      }
	  boolean isBipartite(int grid[][],int V)
       {
          //add code here.
          boolean[] visited = new boolean[V];
          int[] color = new int[V];
          Arrays.fill(visited,false);
          dfs(visited,color,grid,0,1);
          if(bipartite){
              return true;
          }else{
              return false;
          }
          //return false;
        }
}