import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution{
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Entry> queue = new PriorityQueue<>(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o1.cost-o2.cost;
            }
        });
        boolean[][] visited = new boolean[m][n];
        queue.offer(new Entry(0,0,0));
        int[][] dist = new int[m][n];
        for(int[] x:dist){
            Arrays.fill(x,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        while(!queue.isEmpty()){
            Entry curr = queue.poll();
            visited[curr.x][curr.y] = true;
            for(int i = 0;i<4;i++){
                int nx = curr.x+dirs[i][0];
                int ny = curr.y+dirs[i][1];
                if(nx<0 || ny< 0 || nx>=m || ny>= n || visited[nx][ny]){
                    continue;
                }else{
                    int ncost = curr.cost;
                    if(i != (grid[curr.x][curr.y]-1)) ncost+=1;
                    if(dist[nx][ny]>ncost){
                        dist[nx][ny] = ncost;
                        queue.offer(new Entry(nx,ny,ncost));
                    }
                }
            }

        }
        return dist[m-1][n-1];
    }
}
class Entry{
    int x;
    int y;
    int cost;
    Entry(int x,int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}