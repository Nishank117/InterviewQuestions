class Solution {
    //The idea behind solving this problem is to find the apples using dfs 
    //and then the count will be +2 the previous one
    Map<Integer,List<GraphNode>> map;
    Set<Integer> appleSet;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if(n == 0 || edges.length == 0 || hasApple.size() == 0 || edges == null || hasApple == null){
            return 0;
        }
        map = new HashMap<>();
        appleSet = new HashSet<>();
        for(int i = 0;i<edges.length;i++){
            List<GraphNode> list = map.getOrDefault(edges[i][0],new ArrayList<>());
            list.add(new GraphNode(edges[i][1],hasApple.get(i)));
            map.put(edges[i][0],list);
        }
        for(int i = 0;i<n;i++){
            if(hasApple.get(i)) appleSet.add(i);
        }
        System.out.println(appleSet.toString());
        List<GraphNode> list = map.get(0);
        int result = 0;
        if(list!=null){
            for(GraphNode i:list)
            result+=DFS(i.value);
        }
        return result;
    }
    private int DFS(int vertex){
        int count = 0;
        List<GraphNode> list = map.get(vertex);
        if(list == null && appleSet.contains(vertex)){
            return 2;
        }
        if(list != null){
            for(GraphNode children:list){
                count+=DFS(children.value);
            }
            if(appleSet.contains(vertex) || count != 0 ){
                count+=2;
            }
            return count;
        }
       
        
        return count;
    }
}
class GraphNode{
    int value;
    boolean isApple;
    GraphNode(int value, boolean isApple){
        this.value = value;
        this.isApple = isApple;
    }
}