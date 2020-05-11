class Solution {
    //question is similar to number of islands question 
    //we just memorise the max solution till now
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean hasZero = false;
        int max = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0){
                    //we convert the 0 to 1
                    grid[i][j] = 1;
                    //find the area of the largest island in it's neighboourhood
                    max = Math.max(max,dfs(i,j,grid,new boolean[m][n]));
                    if(max == m*n) return max;
                    hasZero = true;
                    //backtrack it 
                    grid[i][j] = 0;
                }
            }
        }
        
        return hasZero?max:m*n;
    }
    private int dfs(int i,int j,int[][] grid,boolean[][] visited){
        if(i < 0|| j< 0|| i>=grid.length ||j>=grid[0].length || grid[i][j] == 0 || visited[i][j] == true) return 0;
        visited[i][j] = true;
        return 1+dfs(i-1,j,grid,visited)+dfs(i+1,j,grid,visited)+dfs(i,j+1,grid,visited)+dfs(i,j-1,grid,visited);
    }
}