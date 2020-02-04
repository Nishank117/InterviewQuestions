
import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0;i<v;i++){
            adj[i] = new LinkedList();
        }
    }
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
    private void addEdge(int v,int w){
        adj[v].add(w);
    }
    void DFSutil(int v,boolean[] visited){
        visited[v] = true;
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSutil(n, visited); 
            }
        
    }
    private boolean isConnected(){
        //to check the visited element
        boolean[] visited = new boolean[V];
        for(int k = 0;k<V;k++){
            visited[k] = false;
        }
        //to find a vertex which has non zero degree
        int i;
        for(i = 0;i<V;i++){
            if(adj[i].size() != 0){
                break;
            }
        }
        
        if(i == V) return true;
        
        DFSutil(i,visited);
        
        for(int j = 0;j<V;j++){
            if(visited[j] == false && adj[j].size() != 0){
                return false;
            }
        }
        return true;
    }
    public boolean isEuler(){
        if(isConnected() == false){
            return false;
        }
        int odd = 0;
        for(int i = 0;i<V;i++){
            if(adj[i].size() % 2 != 0){
                odd++;
            }
        }
        
        if(odd == 2) return true;
        else{
            return false;
        }
        
    }
	public static void main (String[] args) {
		//code
		FastReader fr = new FastReader();
		int t = fr.ni();
		while(t>0){
		   int n = fr.ni();
		   Graph g = new Graph(n);
		   
		   int[][] arr = new int[n][n];
		   for(int i = 0;i<n;i++){
		       for(int j = 0;j<n;j++){
		           arr[i][j] = fr.ni();
		       }
		   }
		   
		   for(int i = 0;i<n;i++){
		       for(int j = 0;j<n;j++){
                    if(arr[i][j] == 1){
                        g.addEdge(i,j);
                    }
		       }
		   }
		   boolean isEulerPath = g.isEuler();
		   if(isEulerPath) System.out.println("1");
		   else{
		       System.out.println("0");
		   }
		   		t--;

		}
	}
}