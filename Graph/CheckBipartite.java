class GfG
{
      boolean bipartite = true;
      private void dfs(boolean[] visited,int[] color,int[][] grid,int src,int currentColor){
          visited[src] = true;
          color[src] = currentColor;
          for(int i = 0;i<visited.length;i++){
              if(grid[src][i] == 1){
                  if(color[i] == currentColor){
                      bipartite = false;
                      return;
                  }
              }
              if(!visited[i]){
                  dfs(visited,color,grid,i,currentColor==1?2:1);
              }
          }
      }
	  boolean isBipartite(int grid[][],int V)
       {
          //add code here.
          boolean[] visited = new boolean[V];
          int[] color = new int[V];
          //making sure none of them is visited
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