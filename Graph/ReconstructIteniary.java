class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //Solution is simple to apply dfs with priority queue.
        Map<String,PriorityQueue<String>> routes = new HashMap<>();
        for(List<String> t:tickets){
            routes.putIfAbsent(t.get(0),new PriorityQueue<>());
            routes.get(t.get(0)).offer(t.get(1)); 
        }
        List<String> ans = new ArrayList<>();
        dfs(routes,ans,"JFK");
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(Map<String,PriorityQueue<String>> routes,List<String> ans,String from){
        PriorityQueue<String> destination = routes.getOrDefault(from,new PriorityQueue<>());
        while(!destination.isEmpty()){
            dfs(routes,ans,destination.poll());
        }
        ans.add(from);
    }
}