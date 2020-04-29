
class Trie{
    TrieNode root = new TrieNode();
    public void insert(String str){
        TrieNode curr = root;
        for(int i = 0;i<str.length();i++){
            int index = str.charAt(i)-'a';
            if(curr.tries[index] == null){
                curr.tries[index] = new TrieNode();
            }
            curr = curr.tries[index]; 
        }
        curr.isWord = true;
        curr.word = str;
    }
    public boolean search(String str){
        TrieNode curr = root;
        for(int i = 0;i<str.length();i++){
            int index = str.charAt(i)-'a';
            if(curr.tries[index] == null){
                return false;
            }
            curr = curr.tries[index];
        }
        return curr !=null && curr.isWord;
    }
}
class TrieNode{
    TrieNode[] tries = new TrieNode[26];
    String word = null;
    boolean isWord = false;
    TrieNode(){
    for(int i = 0;i<26;i++){
            tries[i] = null;
        }
    }
}
class Solution {
    Set<String> results;
    int[] x = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    public boolean outside(char[][] board, int i , int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return true;
        return false;
    }
    public List<String> findWords(char[][] grid, String[] words) {
        Trie tr = new Trie();
        TrieNode root = tr.root;
        for(String word:words){
            tr.insert(word);
        }
        results = new HashSet<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                char c = grid[i][j];
                if(root.tries[c-'a']!=null){
                    dfs(grid,i,j,root,c);
                }
            }
        }
        return new ArrayList<>(results);
    }
    public void dfs(char[][] grid,int i,int j,TrieNode curr,char c){
        if(outside(grid,i,j) || grid[i][j] == '#' || curr.tries[c-'a'] == null){
            return;
        }
        char t = grid[i][j];
        grid[i][j] = '#';
        curr = curr.tries[t-'a'];
        if(curr.isWord && curr != null){
            results.add(curr.word);
        }
        
        for(int k = 0;k<x.length;k++){
            int row = i+x[k];
            int column = j+y[k];
            if(outside(grid,row,column)) continue;
            dfs(grid,row,column,curr,grid[i][j]);
        }
        grid[i][j] = t;
        
    }
}
