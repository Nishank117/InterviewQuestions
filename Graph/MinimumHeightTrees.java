//very good graph question.
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<= 0) return new ArrayList<>();
        
        List<Integer> leaves = new ArrayList<>();
        if(n == 1){
            leaves.add(0);
            return leaves;
        }
        //Building the graph
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            List<Integer> setA = graph.getOrDefault(a,new ArrayList<>());
            setA.add(b);
            graph.put(a,setA);
            List<Integer> setB = graph.getOrDefault(b,new ArrayList<>());
            setB.add(a);
            graph.put(b,setB);
        }
        for(Map.Entry<Integer,List<Integer>> entry: graph.entrySet()){
            if(entry.getValue().size() == 1){
                leaves.add(entry.getKey());
            }
        }
        
        return leafTrimming(graph,leaves);
    }
    public List<Integer> leafTrimming(Map<Integer,List<Integer>> graph,List<Integer> leaves){
        //which is our main goal.
        //we want to keep shedding the leaves so that we can have at last the middle element or elements.
        if(graph.size()<= 2){
            return new ArrayList<>(graph.keySet());
        }
        //removing the leaves from the list as well as their connections in the graph.
        List<Integer> newLeafList = new ArrayList<>();
        for(Integer leaf:leaves){
            Integer neighbour = graph.get(leaf).get(0);
            graph.get(neighbour).remove(leaf);
            if(graph.get(neighbour).size() == 1){
                newLeafList.add(neighbour);
            }
            graph.remove(leaf);
            
        }
        
        
        return leafTrimming(graph,newLeafList);
    }
}