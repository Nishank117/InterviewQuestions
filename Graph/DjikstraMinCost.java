
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
     static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int ni() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    private static int findMinimum(int[][] dist,boolean[][] visited){
        int result = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0;i<dist.length;i++){
            for(int j = 0;j<dist.length;j++){
                if(!visited[i][j] && result>dist[i][j]){
                    result = dist[i][j];
                    ans = i*dist.length + j;
                }
            }
        }
        return ans;
    }
    private static void pathFinder(int i,int j,int[][] arr,boolean[][] visited,int[][] dist){
        if(i<0||j<0||i>=arr.length||j>=arr[i].length||visited[i][j] == true){
            return;
        }
        
        if(i==arr.length-1 && j ==arr.length-1){
            visited[i][j] = true;
            return;
        }
        if(i<arr.length-1 && !visited[i+1][j]){
            if(dist[i+1][j]>dist[i][j]+arr[i+1][j]){
                dist[i+1][j] = dist[i][j]+arr[i+1][j];
            }
        }
        if(i>0 && !visited[i-1][j]) {
            if(dist[i-1][j]>dist[i][j]+arr[i-1][j]){
                dist[i-1][j] = dist[i][j]+arr[i-1][j];
            }
        }
        if(j<arr.length-1 && !visited[i][j+1]){
            if(dist[i][j+1]>dist[i][j]+arr[i][j+1]){
                dist[i][j+1] = dist[i][j]+arr[i][j+1];
            }
        }
        if(j>0 && !visited[i][j-1]){
            if(dist[i][j-1]>dist[i][j]+arr[i][j-1]){
                dist[i][j-1] = dist[i][j]+arr[i][j-1];
            }
        }
        visited[i][j] = true;
        
        int coordinate = findMinimum(dist,visited);
        // System.out.println(coordinate/arr.length);
        // System.out.println(coordinate%arr.length);
        pathFinder(coordinate/arr.length,coordinate%arr.length,arr,visited,dist);

    }
	public static void main (String[] args) {
		//code
		FastReader fr = new FastReader();
		int t = fr.ni();
		while(t>0){
		    int n = fr.ni();
		    int[][] arr = new int[n][n];
		    int[][] distance = new int[n][n];
		    for(int[] row: distance){
		        Arrays.fill(row,Integer.MAX_VALUE);
		    }
		    boolean[][] visited = new boolean[n][n];
		    for(int i = 0;i<n;i++){
		        for(int j = 0;j<n;j++){
		            arr[i][j] = fr.ni();
		            visited[i][j] = false; 
		        }
		    }
		  //  for(int i = 0;i<n;i++){
		  //      for(int j = 0;j<n;j++){
		  //          System.out.print(arr[i][j] + " ");
		  //      }
		  //      System.out.println();
		  //  }
		  //  System.out.println();
		    distance[0][0] = arr[0][0];
		    HashSet<String> set = new HashSet<>();
		    pathFinder(0,0,arr,visited,distance);
		  //  int result = 0;
		  //  for(int i = 0;i<n;i++){
		  //      for(int j = 0;j<n;j++){
		  //          if(visited[i][j] == true){
		  //              result += arr[i][j];
		  //          }
		  //      }
		  //  }
		    System.out.println(distance[n-1][n-1]);
		    
		    t--;
		}
	}
}