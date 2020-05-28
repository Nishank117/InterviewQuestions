import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Entry> queue = new PriorityQueue<Entry>(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o1.cost-o2.cost;
            }
        });
        boolean[][] visited = new boolean[m][n];
        queue.offer(new Entry(0,0,grid[0][0]));
        int res = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Entry curr = queue.poll();
            res = Math.max(res,curr.cost);
            if(curr.x == m-1 && curr.y == n-1) return res;
            else{
                for(int i = 0;i<4;i++){
                    int nx = curr.x+dirs[i][0];
                    int ny = curr.y+dirs[i][1];

                    if(nx<0 || ny< 0 || nx>=m || ny>= n || visited[nx][ny]){
                        continue;
                    }else{
                        visited[nx][ny] = true;
                        queue.offer(new Entry(nx,ny,grid[nx][ny]));
                    }
                }
            }
        }
        return 0;
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