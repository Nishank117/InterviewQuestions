// How to solve this question
//do a normal DFS 
//find the starting point
//find the ending point
//find the number of 0s = numEmpty
//so if you find the path we will numEmpty+2 ****
//we will find a unique path.
//basic dfs with backtracking 
//-1 when found don't traverse


class Solution {
    private int n,m,numEmpty;
    private final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    
    private int serial(int x,int y){
        return x*m+y;
    }
    
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        int startX = 0,startY = 0,endX = 0,endY = 0;
        numEmpty = 0;
        Set<Integer> visited = new HashSet<>();
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 0){
                    numEmpty++;
                }
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
                if(grid[i][j] == 2){
                    endX = i;
                    endY = j;
                }
            }
        }
        
        visited.add(serial(startX,startY));
        return countPaths(startX,startY,visited,endX,endY,grid);
    }
    
    private int countPaths(int x,int y,Set<Integer> visited,int endX,int endY,int[][] grid){
        // ***** condition written above to satisfy
        if(x == endX && y == endY && visited.size() == numEmpty+2){
            return 1;
        }
        int count = 0;
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= n | ny >= m || grid[nx][ny] == -1) continue;
            int norder = serial(nx, ny);
            if (!visited.contains(norder)) {
                visited.add(norder);
                count += countPaths(nx, ny, visited, endX, endY, grid);
                visited.remove(norder);
            }
        }

        return count;
    }
  
    
}