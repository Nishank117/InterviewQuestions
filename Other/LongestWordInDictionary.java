
class Solution {
    class TrieNode{
        String word = "";
        TrieNode[] children = new TrieNode[26];
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        if(words == null || words.length == 0){
           return "";
        }
        for(String word:words){
            TrieNode curr = root;
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null) 
                    curr.children[c-'a'] = new TrieNode();
                curr = curr.children[c-'a'];
            }
            curr.word = word;
        }
        
        return dfs(root);
    }
    
    private String dfs(TrieNode node){
        String res = node.word;
        for(TrieNode child : node.children){
            // for example banana  since it is not having any build up all the word lengths will be 0
            // untill we reach banana so it is automatically discarded
            if(child != null && child.word.length() != 0){
                //find other strings
                String ans = dfs(child);
                if(res.length()<ans.length() || (res.length() == ans.length() && ans.compareTo(res)<0)){
                    res = ans;
                }
            }
            
        }
        return res;
    }
}