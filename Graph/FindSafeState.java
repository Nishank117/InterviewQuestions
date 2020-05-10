class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        if(graph.length == 0 || graph  == null){
            return new ArrayList<Integer>();
        }
        int[] color = new int[graph.length];
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            if(DFS(graph,color,i)){
                result.add(i);
            }
        }
        return result;
    }
    private boolean DFS(int[][] graph,int[] color,int vertex){
        if(color[vertex] > 0){
            //which effectively means that the node is in blackset if not false.
            return color[vertex] == 2;
        }
        //if it is 0 which means unvisited or in white set
        color[vertex] = 1;
        for(int child:graph[vertex]){
            if(color[child] == 2){
                //which again means it's child is in black set so no problem
                continue;
            }
            //again we are going into to check if its child is in the gray set
            //also check for the DFS of it's child if it doesn't have a cycle
            // if it's child has a cycle then the parent is also not safe.
            if(color[child] == 1 || !DFS(graph,color,child)){
                return false;
            }
        }
        //once done put the node into black set.
        color[vertex] = 2;
        return true;
    }
}