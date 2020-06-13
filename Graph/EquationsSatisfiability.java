class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
        }
        //create all the connected components
        for(String str:equations){
            if(str.charAt(1) == '!') continue;
            union(str.charAt(0)-'a',str.charAt(3)-'a');
        }
        for(String eq:equations){
            if(eq.charAt(1) == '!'){
                if(find(eq.charAt(0)-'a') == find(eq.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
    private int find(int x){
        if(parent[x] != x){
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x,int y){
        if(find(x) == find(y)){
            return;
        }else{
            parent[find(x)] = find(y);
        }
    }
}