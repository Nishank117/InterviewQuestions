class DetectCycle
{
    private static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> list,int v,int parent,boolean[] visited){
        visited[v] = true;
        Iterator<Integer> it = list.get(v).listIterator();
        while(it.hasNext()){
            int i = it.next();
            if(!visited[i]){
                if(isCyclicUtil(list,i,v,visited)){
                    return true;
                }
            }else if(i != parent){
                return true;
            }
        }
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
       // add your code here
       boolean[] visited = new boolean[V];
       for(int i = 0;i<V;i++){
           visited[i] = false;
       }
       for(int i = 0;i<V;i++){
           if(!visited[i]){
               if(isCyclicUtil(list,i,-1,visited)){
                   return true;
               }
           }
       }
       return false;
    }
}