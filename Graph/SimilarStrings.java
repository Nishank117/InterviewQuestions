// Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.
// For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
// Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
// We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

Input: A = ["tars","rats","arts","star"]
Output: 2
class Solution {
    public int numSimilarGroups(String[] A) {
        //we will be using connected components with DFS to solve the question
        if(A == null || A.length == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0;i<A.length;i++){
            if(A[i] == null) continue;
            //in this step we try to find all the strings which are 
            //similar to one another, so in the example once we encounter a word we need
            // to strike off all the similar words for that word
            // first we take tars
            String str = A[i];
            // after getting the word we make it null.
            A[i] = null;
            res++;
            dfs(str,A);
        }
        return res;
    }
    private void dfs(String str,String[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == null) continue;
            if(helper(arr[i],str)){
                String s = arr[i];
                arr[i] = null;
                //this will handle the case of tars and arts even though there are not same 
                //we will have them in the same connected group because it has a
                //common word rats which makes them all similar
                dfs(s,arr);
            }
        }
    }
    
    private boolean helper(String a,String b){
        int changes = 0;
        if(a.length() != b.length()){
            return false;
        }
        if(a.equals(b)){
            return true;
        }
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                changes++;
            }
        }
        
        return changes == 2;
    }
}