import java.io.*;
import java.util.*;
class Graph{
    private int V;
    private LinkedList<Integer> adj[];
    private int[] in;
    private int[] out;
    
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        in = new int[v];
        out = new int[v];
        for(int i = 0;i<V;i++){
            adj[i] = new LinkedList();
            in[i] = 0;
            out[i] = 0;
        }
    }
    private void addEdge(int v,int w){
        adj[v].add(w);
        in[w]++;
        out[v]++;
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
    private void DFSUtil(int s, boolean[] visited){
        visited[s] = true;
        
        Iterator<Integer> it = adj[s].listIterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }
    private boolean DFS(){
        boolean[] visited = new boolean[V];
	    Arrays.fill(visited,false);
	    
        int i = 0;
	    for(;i<V;i++){
	        if(adj[i].size() > 0){
	            break;
	        }
	    }
	    if(i == V){
	        return true;
	    }
	    DFSUtil(i,visited);
	    
	    
	    for(int k = 0;k<V;k++){
	        if(!visited[k] && adj[k].size() != 0){
	            return false;
	        }
	    }
	    return true;
	    
    }
    private int isEuler(){
        
        for(int k = 0;k<V;k++){
	        if(in[k] != out[k]){
	            return 0;
	        }
	    }
        if(!DFS()){
            return 0;
        }

        return 1;
       
    }
	public static void main (String[] args) {
		//code
		FastReader fr = new FastReader();
		int t = fr.ni();
		while(t>0){
		    int n = fr.ni();
		    Graph g = new Graph(26);
		    String[] arr = new String[n];
		    
		    for(int i = 0;i<n;i++ ){
		        arr[i] = fr.next();
		    }
		    for(int i = 0;i<n;i++ ){
		        char ch = 'a';
		        int ascii = ch;
		        int start = arr[i].charAt(0);
		        int end = arr[i].charAt(arr[i].length()-1);
		        g.addEdge(start-ascii,end-ascii);
		        //g.addEdge(end-ascii,start-ascii);
		    }
		    
		    System.out.println(g.isEuler());
		    t--;
		}
	}
}