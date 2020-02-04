/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class TSP {
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
    static int min = Integer.MAX_VALUE;
    private static void minCost(int[][] arr){
        boolean[] visited = new boolean[arr.length];
        int source = 0;
        min = Integer.MAX_VALUE;
        dfs(source,source,arr,visited,1,0);
        System.out.println(min);
        
    }
    private static void dfs(int src,int c_src,int[][] arr,boolean[] visited,int count,int cost){
        if(count == arr.length && arr[c_src][src] != 0){
            min = Math.min(min,cost+arr[c_src][src]);
            return;
        }
        visited[c_src] = true;
        for(int i = 0;i<arr.length;i++){
            if(arr[c_src][i] != 0 && !visited[i]){
                dfs(src,i,arr,visited,count+1,cost+arr[c_src][i]);
            }
        }
        visited[c_src] = false;
    }
	public static void main (String[] args) {
		//code
		FastReader fr = new FastReader();
		int t = fr.ni();
		while(t-->0){
		    int n = fr.ni();
		    int[][] arr = new int[n][n];
		    for(int i = 0;i<n;i++){
		        for(int j = 0;j<n;j++){
		            arr[i][j] = fr.ni();
		        }
		    }
		    minCost(arr);
		}
	}
}