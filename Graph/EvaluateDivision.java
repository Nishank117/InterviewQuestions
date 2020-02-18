//My Approach doesn't works after the first iteration
class Node{
    String node;
    double dist;
    Node(String node,double dist){
        this.node = node;
        this.dist = dist;
    }
}
    
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values,List<List<String>> queries){
      Map<String,List<Node>> graph = new HashMap<>();
        int count = 0;
        for(List<String> e: equations){
            double distance = values[count++];
            double invertDistance = 1.0/distance;
            graph.putIfAbsent(e.get(0),new ArrayList<>());
            graph.get(e.get(0)).add(new Node(e.get(1),distance));
            graph.putIfAbsent(e.get(1),new ArrayList<>());
            graph.get(e.get(1)).add(new Node(e.get(0),invertDistance));
        }
        double[] res = new double[queries.size()];
        List<String> visited = new ArrayList<>();
        int i = 0;
        for(List<String> query:queries){
            String src = query.get(0);
            String dest = query.get(1);
            res[i] = -1.0;
            if(graph.containsKey(src)){
                dfs(src,dest,visited,res,graph,i++,1.0);
            }
            
        }
        return res;  
    }
    public void dfs(String src,String dest,List<String> visited ,double[] res,Map<String,List<Node>> graph,int index,double result ){
        if(src.equals(dest)){
            res[index]  = result;
            visited.clear();
            return;
        }
        visited.add(src);
        List<Node> srcList = graph.get(src);
        if(index == 1){
            for(List<Node> s:srcList){
                System.out.print(":"+s.node);
            }
        }
        int i = 0;
        while(!srcList.isEmpty()){
            Node nextSrc = srcList.get(0);
            srcList.remove(0);
            String newSrc = nextSrc.node;
            System.out.println("The result is: "+result+" newSrc is "+newSrc);
            if(!visited.contains(newSrc)){
                result *= nextSrc.dist;
                dfs(newSrc,dest,visited,res,graph,index,result);
            }
        }
        return;
        
    }

    //accepted answer
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
           HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
            int ind = 0;
            for (List<String> eqList : equations) {
                double val = values[ind++];
                String src = eqList.get(0);
                String dest = eqList.get(1);
                HashMap<String, Double> adj = map.getOrDefault(src, new HashMap<String, Double>());
                adj.put(dest, val);
                map.put(src, adj);
                HashMap<String, Double> adjRevrse = map.getOrDefault(dest, new HashMap<String, Double>());
                adjRevrse.put(src, 1.0 / val);
                map.put(dest, adjRevrse);
            }
            double[] res = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                List<String> list = queries.get(i);
                String src = list.get(0);
                String dest = list.get(1);
                res[i] = -1.0;
                HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
                for (String start : map.keySet()) {
                    if (start.equals(src)) {
                        res[i] = solveEq(src, dest, map, visited, 1.0);
                        break;
                    }
                }
            }
            return res;
        }
    
        private double solveEq(String curr, String dest, HashMap<String, HashMap<String, Double>> map,
                HashMap<String, Boolean> visited, double result) {
            if (curr.equals(dest))
                return result;
            visited.put(curr, true);
            HashMap<String, Double> adj = map.get(curr);
            for (String neighbor : adj.keySet()) {
                if (!visited.containsKey(neighbor)) {
                    double temp = solveEq(neighbor, dest, map, visited, result * adj.get(neighbor));
                    if (temp != -1.0)
                        return temp;
                }
            }
            return -1.0;
        }
    }
    
    
} 
