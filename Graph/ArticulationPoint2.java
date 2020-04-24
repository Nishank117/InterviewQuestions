class Solution {
    
    public ArrayList<Integer>[] graph ; 
    public List<List<Integer>> res ;
    int[] visitedTimes ;
    int[] lowTimes ; 
    int time ;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        // adjacency list ;
        buildList( n , connections ) ;
        
        //initialize visited and low times array 
        visitedTimes = new int[n] ;
        lowTimes = new int[n] ;
        
        // result list
        res =  new ArrayList<List<Integer>>() ; 
        
        //to mark visited nodes create a boolean visited array
        boolean[] visited = new boolean[n] ;
        
        time = 0 ; 
        
        dfsOnGraph( visited , 0 , -1 ) ; // starting with currNode 0 and parentNode -1
         
        return res ;
    }
    
    private void dfsOnGraph( boolean[] visited, int currNode , int parentNode ) {
        
        // mark node as visited
        visited[currNode] = true ;
        
        // mark the visited time for the node
        visitedTimes[currNode] = time ; 
        lowTimes[currNode] = time ;
        time++ ;
        
        // explore neighbors 
        for( int neig : graph[currNode] ) {
            
            if( neig == parentNode ) continue ;
            
            if( !visited[neig] ) {
                dfsOnGraph( visited , neig , currNode ) ;
                
                lowTimes[currNode] = Math.min(lowTimes[currNode] , lowTimes[neig] ) ; // back propogate lowest time in a cycle
                                                                                      // so all nodes are updated with lowest
                                                                                      // lowTimes in that cycle
																					  
                // once dfs ends check 
                // if for curr node the visitedTime is less than lowTime of neig 
                // that indicates there is no backgate for the neig for its lowTime to be updated
                if( visitedTimes[currNode] < lowTimes[neig] ) {
                    res.add(Arrays.asList( currNode , neig )) ;         // found articulation point 
                }
            } else {
                    // explored a backgate to the node
                    // means there is no articulation point 
                lowTimes[currNode] = Math.min( lowTimes[currNode] , visitedTimes[neig] ) ;
                
				// here 1's lowTime is updated since when we have currNode 1 and neigbor is 0 we
				// come into this else part here and update the 1's lowTime .
				
                // here  3's lowTime is not updated since there is no way we can reach 3 via 2 or 0 
				//since we do not arrive here so 3's low time and visited time remains greater
                
            } 
        }
              
        
    }
   
   //building the adjanceny list
    private void buildList( int noOfNodes , List<List<Integer>> connections ) {
        
        graph = new ArrayList[noOfNodes] ;
        
        for( int i = 0 ; i < graph.length ; i++ ) {
            graph[i] = new ArrayList<Integer>() ;
        }
        
        for( List<Integer> conn : connections ) {
            
            int fNode = conn.get(0) ;
            int sNode = conn.get(1) ;
            
            graph[fNode].add(sNode) ;
            graph[sNode].add(fNode) ;
            
        }
 
        
    }
    
}